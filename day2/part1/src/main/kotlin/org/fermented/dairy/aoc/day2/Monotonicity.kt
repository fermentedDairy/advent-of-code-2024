package org.fermented.dairy.aoc.day2

enum class Monotonicity {
    INCREASING,
    DECREASING;

    companion object {
        fun compare(first: Int, left: Int): Monotonicity = if (first <= left) INCREASING else DECREASING
    }
}