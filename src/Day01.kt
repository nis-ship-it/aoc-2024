import java.io.File
import kotlin.math.abs

fun main() {

    val lines = File("./Day01.txt").readLines()
    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()

    for(line in lines){
        val numbers = line.split(Regex("\\s{3,}"))
        leftList.add(numbers[0].toInt())
        rightList.add(numbers[1].toInt())
    }
    q2(leftList, rightList)

}



fun q1(leftList: MutableList<Int>, rightList: MutableList<Int>) {

    leftList.sort()
    rightList.sort()

    var distance = 0

    for (i in leftList.indices){
        distance += abs(rightList[i] - leftList[i])
    }

    println(distance)
}

fun q2(leftList: MutableList<Int>, rightList: MutableList<Int>) {
    var similarityScore = 0

    for (leftValue in leftList) {
        val countRight = rightList.count() { it == leftValue }

        similarityScore += leftValue * countRight
    }

    println(similarityScore)
}

