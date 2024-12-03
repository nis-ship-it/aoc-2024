import java.io.File

fun main() {
    val lines = File("./Day03.txt").readLines()
    val pattern = Regex("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)")

    val matches = pattern.findAll(lines.toString())
    var isEnabled = true

    var total = 0
    for (m in matches) {
        val value = m.value

        when {
            value == "do()" -> {
                isEnabled = true
            }
            value == "don't()" -> {
                isEnabled = false
            }
            value.startsWith("mul") -> {
                val numbers = Regex("\\d+").findAll(value).map { it.value.toInt() }.toList()
                if (numbers.size == 2 && isEnabled) {

                    val (x, y) = numbers
                    total += x * y
                }
            }
        }
    }

    println(total)

}