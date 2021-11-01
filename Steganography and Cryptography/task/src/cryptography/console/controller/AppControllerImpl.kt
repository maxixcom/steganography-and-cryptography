package cryptography.console.controller

import cryptography.console.command.CommandHide
import cryptography.console.command.CommandShow

class AppControllerImpl : AppController {
    override fun show(command: CommandShow) {
        println("Obtaining message from image.")
    }

    override fun hide(command: CommandHide) {
        println("Hiding message in image.")
    }
}
