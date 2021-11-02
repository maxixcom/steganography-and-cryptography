package cryptography.domain.gateway

import java.awt.image.BufferedImage

interface SecretImage {
    fun hide(input: BufferedImage): BufferedImage
}
