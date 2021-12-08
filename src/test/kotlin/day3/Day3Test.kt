package com.github.rileymichael.day3

import com.github.rileymichael.day3.Day3.part1
import com.github.rileymichael.day3.Day3.part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

    @Test
    fun `part one example`() {
        val actual = Day3.execute(::part1, input)
        assertEquals(198, actual)
    }

    @Test
    fun `part one solution`() {
        val actual = Day3.execute(::part1)
        assertEquals(3882564, actual)
    }

    @Test
    fun `part two example`() {
        val actual = Day3.execute(::part2, input)
        assertEquals(230, actual)
    }

    @Test
    fun `part two solution`() {
        val actual = Day3.execute(::part2)
        assertEquals(3385170, actual)
    }

    companion object {
        private val input = """
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010
        """.trimIndent()
    }
}