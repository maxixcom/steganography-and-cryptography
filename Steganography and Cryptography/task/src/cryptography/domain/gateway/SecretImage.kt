package cryptography.domain.gateway

import java.awt.image.BufferedImage

interface SecretImage {
    fun hide(message: String, password: String, input: BufferedImage): BufferedImage
    fun show(password: String, input: BufferedImage): String
}
