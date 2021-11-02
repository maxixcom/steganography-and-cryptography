package cryptography.domain.gateway

import java.awt.image.BufferedImage

interface SecretImage {
    fun hide(message: String, input: BufferedImage): BufferedImage
    fun show(input: BufferedImage): String
}
