import java.awt.Color
import java.awt.image.BufferedImage
import java.awt.image.BufferedImage.TYPE_INT_RGB

fun drawLines(): BufferedImage {
    val image = BufferedImage(200, 200, TYPE_INT_RGB)
    val graphics = image.createGraphics()
    graphics.color = Color.RED
    graphics.drawLine(0, 0, image.width, image.height)
    graphics.color = Color.GREEN
    graphics.drawLine(image.width, 0, 0, image.height)
    return image
}
