package org.fermented.dairy.aoc.day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigInteger


class CalculatorTest {
    @Test
    @DisplayName("Test data set")
    fun testDataSet() {
        val similarity = Calculator().calculate("src/test/resources/testNumbers.txt")

        assertEquals(BigInteger.valueOf(31), similarity) { "similarity doesn't match" }
    }

    @Test
    @DisplayName("Main data set")
    fun mainDataSet() {
        val similarity = Calculator().calculate("src/main/resources/numbers.txt")

        assertEquals(BigInteger.valueOf(31), similarity) { "similarity doesn't match" }
    }
}