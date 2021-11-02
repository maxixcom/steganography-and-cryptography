package cryptography.console.controller

import cryptography.console.command.CommandHide
import cryptography.console.command.CommandShow
import cryptography.domain.usecase.Hide
import cryptography.domain.usecase.Show

class AppControllerImpl(
    private val useCaseHide: Hide,
    private val useCaseShow: Show,
) : AppController {
    override fun show(command: CommandShow) {
        val request = Show.Request(
            inputFile = command.inputFile
        )
        useCaseShow.execute(request).result.fold(
            { message ->
                println("Message:\n$message\n")
            },
            {
                println(it.message)
            }
        )
    }

    override fun hide(command: CommandHide) {
        val request = Hide.Request(
            message = command.message,
            inputFile = command.inputFile,
            outputFile = command.outputFile,
        )

        useCaseHide.execute(request).result.fold(
            {
                println("Message saved in ${request.outputFile} image.")
            },
            {
                println(it.message)
            }
        )
    }
}
