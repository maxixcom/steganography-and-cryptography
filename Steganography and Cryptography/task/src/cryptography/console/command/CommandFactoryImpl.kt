package cryptography.console.command

class CommandFactoryImpl : CommandFactory {
    private val commands: List<(String) -> Command?> = listOf(
        { input -> parseExit(input) },
        { input -> parseShow(input) },
        { input -> parseHide(input) },
    )

    override fun commandFromString(input: String) = commands.firstNotNullOfOrNull { it(input) } ?: CommandUnknown

    private fun parseExit(input: String): Command? {
        return "^exit$".toRegex().matchEntire(input)?.let {
            CommandExit
        }
    }

    private fun parseShow(input: String): Command? {
        return "^show$".toRegex().matchEntire(input)?.let {
            println("Input image file:")
            val inputFile = readLine()!!
            println("Password:")
            val password = readLine()!!
            CommandShow(inputFile, password)
        }
    }

    private fun parseHide(input: String): Command? {
        return "^hide$".toRegex().matchEntire(input)?.let {
            println("Input image file:")
            val inputFile = readLine()!!
            println("Output image file:")
            val outputFile = readLine()!!
            println("Message to hide:")
            val message = readLine()!!
            println("Password:")
            val password = readLine()!!
            CommandHide(message, password, inputFile, outputFile)
        }
    }
}
