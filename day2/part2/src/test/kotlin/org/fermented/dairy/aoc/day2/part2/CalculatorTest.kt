package org.fermented.dairy.aoc.day2.part2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculatorTest {
  @Test
  @DisplayName("Verify Test File Result")
  fun testTestFileVerify() {
   assertEquals(4, Calculator().calculate("src/test/resources/testGrid.txt") )
  }

    @Test
    @DisplayName("Verify Actual File Result")
    fun testActualFileVerify() {
        assertEquals(4, Calculator().calculate("src/main/resources/grid.txt") )
    }
}