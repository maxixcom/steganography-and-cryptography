package cryptography.domain.usecase

interface Hide {
    fun execute(request: Request): Response
    data class Request(
        val message: String,
        val password: String,
        val inputFile: String,
        val outputFile: String
    )

    data class Response(val result: Result<Boolean>)
}
