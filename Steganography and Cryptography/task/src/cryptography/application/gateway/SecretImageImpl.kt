package cryptography.application.gateway

import cryptography.application.extensions.pixelForIndex
import cryptography.domain.gateway.SecretImage
import java.awt.image.BufferedImage
import kotlin.experimental.xor

class SecretImageImpl : SecretImage {
    companion object {
        val EOM = listOf<Byte>(0, 0, 3)
    }

    override fun show(password: String, input: BufferedImage): String {
        val totalPixels = input.width * input.height

        val data = mutableListOf<Byte>()
        var index = 0
        while (index < totalPixels) {
            var bins = ""
            for (n in 0..7) {
                val pixel = input.pixelForIndex(index)
                val rgb = input.getRGB(pixel.x, pixel.y)
                bins += (rgb and 1).toString(2)
                index++
            }
            data.add(bins.toByte(2))
            if (data.size > 2) {
                if (data.takeLast(3) == EOM) {
                    break
                }
            }
        }
        val message = xorMessage(
            data.subList(0, data.size - EOM.size).toByteArray(),
            password.toByteArray()
        )
        return message.toString(Charsets.UTF_8)
    }

    override fun hide(message: String, password: String, input: BufferedImage): BufferedImage {
        val data = xorMessage(message.encodeToByteArray(), password.encodeToByteArray())
            .toMutableList()
        data.addAll(EOM) // End of message
        val requiredPixels = data.size * 8
        val totalPixels = input.width * input.height

        if (requiredPixels > totalPixels) {
            throw Exception("The input image is not large enough to hold this message.")
        }

        val output = BufferedImage(input.width, input.height, BufferedImage.TYPE_INT_RGB)

        var index = 0
        for (byte in data) {
            val b = "%08d".format(byte.toString(2).toInt())
            b.map { it.digitToInt() }
                .forEach {
                    val pixel = input.pixelForIndex(index)
                    val rgb = input.getRGB(pixel.x, pixel.y)
                    output.setRGB(pixel.x, pixel.y, rgb and 0xFFFFFE or it)
                    index++
                }
        }
        (index until totalPixels).forEach { i ->
            val pixel = input.pixelForIndex(i)
            output.setRGB(pixel.x, pixel.y, input.getRGB(pixel.x, pixel.y))
        }

        return output
    }

    private fun xorMessage(message: ByteArray, password: ByteArray): ByteArray {
        val size = password.size
        return message.mapIndexed { index, byte ->
            byte xor password[index % size]
        }.toByteArray()
    }
}
