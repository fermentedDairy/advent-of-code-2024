package org.fermented.dairy.aoc.day2

import java.io.File

class Calculator {
    fun calculate(filename: String): Int =
        readFile(filename) { line ->
            line.split(" ")
                .map{ it.toInt() }
                .toList()
        }.map {
            report ->
            val status = if (report.size == 1) {
                Status.SAFE
            } else {
                val monotonicity: Monotonicity = Monotonicity.compare(report[0], report[1])
                for (i in 2 until report.size) {
                    if (Monotonicity.compare(report[i - 1], report[i]) != monotonicity) {
                        return@map Status.UNSAFE
                    } else if (distance(report[i - 1], report[i]) > 3) {
                        return@map Status.UNSAFE
                    }
                }
                return@map Status.SAFE
            }
        }.count { it == Status.SAFE }

    private fun <T> readFile(fileName: String, builder: (String) -> T): List<T> =
        File(fileName).useLines { lines ->
            lines.map { line ->
                builder(line)
            }.toList()
        }

    private fun distance(p1: Int, p2: Int): Int = maxOf(p1, p2) - minOf(p1, p2)
}

