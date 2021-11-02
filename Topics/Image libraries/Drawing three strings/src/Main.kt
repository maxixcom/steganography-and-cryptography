import java.awt.Color
import java.awt.image.BufferedImage

fun drawStrings(): BufferedImage {
    val str = "Hello, images!"
    val image = BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB)
    val graphics = image.createGraphics()
    for ((c, pos) in mapOf(Color.RED to 50, Color.GREEN to 51, Color.BLUE to 52)) {
        with(graphics) {
            color = c
            drawString(str, pos, pos)
        }
    }
    return image
}
