import java.io.File

fun main() {
    val lines = File("./Day03.txt").readLines()
    val pattern = Regex("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)")
    var isEnabled = true
    var total = 0

    lines.forEach { line ->
        pattern.findAll(line).forEach { matchResult ->
            when {
                matchResult.value == "do()" -> isEnabled = true
                matchResult.value == "don't()" -> isEnabled = false
                matchResult.value.startsWith("mul") -> {
                    val (x, y) = matchResult.destructured.toList().map { it.toInt() }
                    if (isEnabled) total += x * y
                }
            }
        }
    }


    println(total)

}