package cryptography.console.command

interface CommandFactory {
    fun commandFromString(input: String): Command
}
