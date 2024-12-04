package org.fermented.dairy.aoc.day2

import java.io.File

class Calculator {
    fun calcutate(filename: String): Int {

    }

    private fun <T> readFile(fileName: String, builder: (String) -> T): Sequence<List<T>> =
        File(fileName).useLines { lines ->
            lines.map { line ->
                line.split("").map(builder).toList()
            }
        }
}

