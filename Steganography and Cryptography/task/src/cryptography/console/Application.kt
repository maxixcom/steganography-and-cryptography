package cryptography.console

import cryptography.console.command.CommandFactory
import cryptography.console.command.CommandFactoryImpl
import cryptography.console.controller.AppController
import cryptography.console.controller.AppControllerImpl

object Application {
    val commandFactory: CommandFactory = CommandFactoryImpl()
    val appController: AppController = AppControllerImpl()
}
