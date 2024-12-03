import java.io.File
import kotlin.math.abs

fun main() {
    val reports = File("./Day02.txt").readLines()




    fun isSafe(report: List<Int>): Boolean {
        var isIncreasing = true
        var isDecreasing = true

        for (i in 1 until report.size) {
            val diff = report[i] - report[i - 1]
            if (diff !in 1..3 && diff !in -3..-1) {
                return false // Difference not within valid range
            }

            if (report[i] > report[i - 1]) {
                isDecreasing = false
            } else if (report[i] < report[i - 1]) {
                isIncreasing = false
            }
        }

        return isIncreasing || isDecreasing // Report is safe if it is monotonic (either increasing or decreasing)
    }

    fun canBeSafeByRemovingOneLevel(report: List<Int>): Boolean {
        for (i in report.indices) {
            val modifiedReport = report.toMutableList()
            modifiedReport.removeAt(i) // Remove the level at index i

            // Check if the modified report is safe
            if (isSafe(modifiedReport)) {
                return true
            }
        }
        return false
    }

    var safeReportCount = 0
    for (report in reports) {
        val reportList = report.split(" ").map { it.toInt() }
        if (isSafe(reportList) || canBeSafeByRemovingOneLevel(reportList)) {
            safeReportCount++
        }
    }

    println(safeReportCount)

}