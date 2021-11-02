package cryptography.application.extensions

import cryptography.domain.entity.Pixel
import java.awt.image.BufferedImage

fun BufferedImage.pixelForIndex(index: Int) =
    Pixel(
        x = index % width,
        y = index / width,
    )
