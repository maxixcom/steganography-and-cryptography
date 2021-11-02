package cryptography.domain.usecase

interface Show {
    fun execute(request: Request): Response
    data class Request(val inputFile: String)
    data class Response(val result: Result<String>)
}
