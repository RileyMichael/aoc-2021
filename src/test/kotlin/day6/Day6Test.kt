package com.github.rileymichael.day6

import com.github.rileymichael.day6.Day6.part1
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day6Test {
    @Test
    fun `part one example`() {
        val actual = Day6.execute(::part1, input)
        Assertions.assertEquals(5934L, actual)
    }

    @Test
    fun `part one solution`() {
        val actual = Day6.execute(::part1)
        Assertions.assertEquals(386536L, actual)
    }

    companion object {
        private const val input = "3,4,3,1,2"
    }
}