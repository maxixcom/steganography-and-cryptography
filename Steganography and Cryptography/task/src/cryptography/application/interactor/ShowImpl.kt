package cryptography.domain.usecase

import cryptography.domain.gateway.SecretImage
import java.io.File
import javax.imageio.ImageIO

class ShowImpl(
    val secretImage: SecretImage
) : Show {
    override fun execute(request: Show.Request): Show.Response {
        val result = runCatching {
            val inputFile = File(request.inputFile)
            if (!inputFile.exists() || !inputFile.isFile) {
                throw Exception("Can't read input file!")
            }
            secretImage.show(request.password, ImageIO.read(inputFile))
        }
        return Show.Response(result)
    }
}
