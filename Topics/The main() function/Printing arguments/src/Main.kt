fun main(args: Array<String>) {
    if (args.size != 3) {
        println("Invalid number of program arguments")
        return
    }
    args.forEachIndexed { index, a ->
        println("Argument ${index + 1}: $a. It has ${a.length} characters")
    }
}
