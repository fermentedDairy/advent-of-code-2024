package org.fermented.dairy.aoc.day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigInteger


class CalculatorTest {
    @Test
    @DisplayName("Test data set")
    fun testDataSet() {
        val distance = Calculator().calculate("src/test/resources/testNumbers.txt")

        assertEquals(BigInteger.valueOf(11), distance) { "distance doesn't match" }
    }

    @Test
    @DisplayName("Main data set")
    fun mainDataSet() {
        val distance = Calculator().calculate("src/main/resources/numbers.txt")

        assertEquals(BigInteger.valueOf(11), distance) { "distance doesn't match" }
    }
}