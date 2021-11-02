package cryptography.console

import cryptography.console.command.Command
import cryptography.console.command.CommandExit
import cryptography.console.command.CommandHide
import cryptography.console.command.CommandShow
import cryptography.console.command.CommandUnknown

class Runner : Runnable {
    private val appController = Application.appController
    override fun run() {
        main@ while (true) {
            do {
                printWelcome()
                val command = enterCommand()
                when (command) {
                    CommandExit -> break@main
                    is CommandShow -> appController.show(command)
                    is CommandHide -> appController.hide(command)
                    is CommandUnknown -> println("Wrong task: [input String]")
                }
            } while (command == CommandUnknown)
        }
        printBye()
    }

    private fun enterCommand(): Command {
        return Application.commandFactory.commandFromString(readLine()!!)
    }
}
