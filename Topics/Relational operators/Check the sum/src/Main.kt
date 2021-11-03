fun main() {
    val (a, b, c) = List(3) { readLine()!!.toInt() }
    println(
        if (a + b == 20) {
            true
        } else if (a + c == 20) {
            true
        } else c + b == 20
    )
}
