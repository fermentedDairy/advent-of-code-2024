package org.fermented.dairy.aoc.day2

import java.io.File
import javax.sound.sampled.UnsupportedAudioFileException
import kotlin.math.abs

class Calculator {
    fun calculate(filename: String): Int = readFile(filename) { line ->
            line.split(" ")
                .map { it.toInt() }
                .toList()
        }.map { report ->
            val set = report.windowed(3)
                .map windowMap@{ window ->
                    if (window[0] == window[1] ||
                        abs(window[0] - window[1]) > 3 ||
                        window[1] == window[2] ||
                        abs(window[1] - window[2]) > 3
                    )
                        return@windowMap Status.UNSAFE
                    else if (!(minOf(window.first(), window.last())..maxOf(window.first(), window.last()))
                            .contains(window[1]))
                        return@windowMap Status.UNSAFE
                    else return@windowMap Status.SAFE
                }.toSet()
            return@map set
        }.count { !it.contains(Status.UNSAFE) }


    private fun <T> readFile(fileName: String, builder: (String) -> T): List<T> =
        File(fileName).useLines { lines ->
            lines.map { line ->
                builder(line)
            }.toList()
        }

    private fun distance(p1: Int, p2: Int): Int = maxOf(p1, p2) - minOf(p1, p2)
}

