package org.fermented.dairy.aoc.day1

import java.io.File
import java.math.BigInteger

typealias IntPair = Pair<Int, Int>
typealias IntPairs = List<IntPair>

class Calculator {

    fun calculate(fileName: String): BigInteger {
        return readFile(fileName) {
            pair ->
            pair.mapFirst { it.sorted() }
                .mapSecond { it.sorted() }
        }
            .toPairs()
            .distances()
            .map {it.toBigInteger()}
            .reduce{ a, b -> a + b}
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


    private fun IntPair.distance(): Int {
        return if (first >= second)
            first - second
        else
            second - first
    }

    private fun <A, B> Pair<List<A>, List<B>>.toPairs(): List<Pair<A,B>> {
        require(this@toPairs.first.size == this@toPairs.second.size){ "List not the same size" }

        return first.mapIndexed { index, a ->
            a to this@toPairs.second[index]
        }
    }

    private fun IntPairs.distances(): List<Int> = this@distances.map { it.distance() }
}

