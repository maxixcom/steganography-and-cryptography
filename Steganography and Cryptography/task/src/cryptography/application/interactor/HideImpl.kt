package cryptography.domain.usecase

import cryptography.domain.gateway.SecretImage
import java.io.File
import javax.imageio.ImageIO

class HideImpl(
    private val secretImage: SecretImage
) : Hide {
    override fun execute(request: Hide.Request): Hide.Response {
        val result = kotlin.runCatching {
            val inputFile = File(request.inputFile)
            if (!inputFile.exists() || !inputFile.isFile) {
                throw Exception("Can't read input file!")
            }

            val outputImage = secretImage.hide(request.message, ImageIO.read(inputFile))

            ImageIO.write(outputImage, "png", File(request.outputFile))
        }
        return Hide.Response(result)
    }
}
