import java.awt.Color
import java.awt.image.BufferedImage

fun drawSquare(): BufferedImage =
    BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB).apply {
        createGraphics().run {
            color = Color.RED
            drawRect(100, 100, 300, 300)
        }
    }
