package cryptography.application.gateway

import cryptography.domain.gateway.SecretImage
import java.awt.image.BufferedImage

class SecretImageImpl : SecretImage {
    override fun hide(input: BufferedImage): BufferedImage {
        val output = BufferedImage(input.width, input.height, BufferedImage.TYPE_INT_RGB)
        // When the input image is read, the least significant bit for each color (Red, Green, and Blue)
        // is set to 1. The resulting image will be saved with the provided output image filename in the PNG format.
        for (x in 0 until input.width) {
            for (y in 0 until input.height) {
                output.setRGB(x, y, input.getRGB(x, y) or 0x010101)
            }
        }
        return output
    }
}
