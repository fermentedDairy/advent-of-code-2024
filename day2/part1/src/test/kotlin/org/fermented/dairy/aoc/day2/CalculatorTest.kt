package org.fermented.dairy.aoc.day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculatorTest {
  @Test
  @DisplayName("Verify Test File Result")
  fun testFileVeriy() {
   assertEquals(2, Calculator().calcutate("src/test/resources/testGrid.txt") )
  }
}