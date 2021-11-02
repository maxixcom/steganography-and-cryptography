package cryptography.console.controller

import cryptography.console.command.CommandHide
import cryptography.console.command.CommandShow
import cryptography.domain.usecase.Hide

class AppControllerImpl(
    private val useCaseHide: Hide
) : AppController {
    override fun show(command: CommandShow) {
        println("Obtaining message from image.")
    }

    override fun hide(command: CommandHide) {
        val request = Hide.Request(
            inputFile = command.inputFile,
            outputFile = command.outputFile,
        )

        println("Input Image: ${request.inputFile}")
        println("Output Image: ${request.outputFile}")

        useCaseHide.execute(request).result.fold(
            {
                println("Image ${request.outputFile} is saved.")
            },
            {
                println(it.message)
            }
        )
    }
}
