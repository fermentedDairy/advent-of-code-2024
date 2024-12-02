package org.fermented.dairy.aoc.day2

import java.io.File
import java.math.BigInteger

typealias IntPair = Pair<Int, Int>
typealias IntPairs = List<IntPair>

class Calculator {

    fun calculate(fileName: String): BigInteger {
        val (first, secondMap) = readFile(fileName) {
            pair ->
            pair.mapSecond {
                it.fold(mutableMapOf<Int, BigInteger>()) { acc, value ->
                        acc.compute(value){ _, newVal ->
                            // If key doesn't exist, value will be null
                            newVal?.inc() ?: BigInteger.ONE
                        }
                        acc
                }
            }
        }

        return first.map {
            secondMap.getOrDefault(it, BigInteger.ZERO).multiply(it.toBigInteger())
        }.reduce { acc, value -> acc + value }
    }

    private fun <T> readFile(fileName: String, transformer: (Pair<List<Int>, List<Int>>) -> T): T {
        val pair = File(fileName).useLines { lines ->
            lines.fold(Pair(mutableListOf<Int>(), mutableListOf<Int>())) { acc, line ->
                val values = line.split("   ")
                acc.first.add(values[0].toInt())
                acc.second.add(values[1].toInt())
                acc
            }
        }
        return transformer.invoke(pair)
    }

    private fun <A, B, C> Pair<A, B>.mapFirst(mapper: (A) -> C): Pair<C, B> =
        Pair(mapper(this@mapFirst.first), this@mapFirst.second)

    private fun <A, B, C> Pair<A, B>.mapSecond(mapper: (B) -> C): Pair<A, C> =
        Pair(this@mapSecond.first, mapper(this@mapSecond.second))

}

