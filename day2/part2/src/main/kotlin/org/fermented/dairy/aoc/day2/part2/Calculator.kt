package org.fermented.dairy.aoc.day2.part2

import java.io.File
import kotlin.math.abs

class Calculator {
    fun calculate(filename: String): Int = readFile(filename) { line ->
            line.split(" ")
                .map { it.toInt() }
                .toList()
        }.map { report ->
            val problemIndex = problemIndex(report)
            if (problemIndex == -1) {
                return@map true
            } else if (problemIndex(report.filterIndexed { index, _ -> index != problemIndex }) == -1 ) {
                return@map true
            } else return@map false
        }.count { it == true }


    private fun <T> readFile(fileName: String, builder: (String) -> T): List<T> =
        File(fileName).useLines { lines ->
            lines.map { line ->
                builder(line)
            }.toList()
        }

    private fun problemIndex(report: List<Int>): Int{
        var windowNumber = -1
        val set = report.windowed(3)
            .map windowMap@{ window ->
                windowNumber++
                if (window[0] == window[1] ||
                    abs(window[0] - window[1]) > 3 ||
                    window[1] == window[2] ||
                    abs(window[1] - window[2]) > 3
                )
                    return@windowMap windowNumber + 1
                else if (!(minOf(window.first(), window.last())..maxOf(window.first(), window.last()))
                        .contains(window[1]))
                    return@windowMap windowNumber + 1
                else return@windowMap -1
            }.toSet()
        return set.find { it!=-1 } ?: -1
    }
}

