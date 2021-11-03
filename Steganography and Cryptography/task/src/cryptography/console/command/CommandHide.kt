package cryptography.console.command

class CommandHide(
    val message: String,
    val password: String,
    val inputFile: String,
    val outputFile: String,
) : Command
