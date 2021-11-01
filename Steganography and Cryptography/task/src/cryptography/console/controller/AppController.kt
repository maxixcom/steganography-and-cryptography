package cryptography.console.controller

import cryptography.console.command.CommandHide
import cryptography.console.command.CommandShow

interface AppController {
    fun show(command: CommandShow)
    fun hide(command: CommandHide)
}
