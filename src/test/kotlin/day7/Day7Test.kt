package com.github.rileymichael.day7

import com.github.rileymichael.day7.Day7.part1
import com.github.rileymichael.day7.Day7.part2
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day7Test {
    @Test
    fun `part one example`() {
        val actual = Day7.execute(::part1, input)
        Assertions.assertEquals(37, actual)
    }

    @Test
    fun `part one solution`() {
        val actual = Day7.execute(::part1)
        Assertions.assertEquals(352707, actual)
    }

    @Test
    fun `part two example`() {
        val actual = Day7.execute(::part2, input)
        Assertions.assertEquals(168, actual)
    }

    @Test
    fun `part two solution`() {
        val actual = Day7.execute(::part2)
        Assertions.assertEquals(95519693, actual)
    }

    companion object {
        private const val input = "16,1,2,0,4,2,7,1,2,14"
    }
}