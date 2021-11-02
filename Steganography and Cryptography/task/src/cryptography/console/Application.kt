package cryptography.console

import cryptography.application.gateway.SecretImageImpl
import cryptography.console.command.CommandFactory
import cryptography.console.command.CommandFactoryImpl
import cryptography.console.controller.AppController
import cryptography.console.controller.AppControllerImpl
import cryptography.domain.gateway.SecretImage
import cryptography.domain.usecase.Hide
import cryptography.domain.usecase.HideImpl

object Application {
    private val secretImage: SecretImage = SecretImageImpl()
    private val useCaseHide: Hide = HideImpl(
        secretImage = secretImage
    )

    val commandFactory: CommandFactory = CommandFactoryImpl()
    val appController: AppController = AppControllerImpl(
        useCaseHide = useCaseHide
    )
}
