package com.github.rileymichael.day1

import com.github.rileymichael.day1.Day1.part1
import com.github.rileymichael.day1.Day1.part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {

    @Test
    fun `part one example`() {
        val actual = Day1.execute(::part1, input)
        assertEquals(7, actual)
    }

    @Test
    fun `part one solution`() {
        val actual = Day1.execute(::part1)
        assertEquals(1752, actual)
    }

    @Test
    fun `part two example`() {
        val actual = Day1.execute(::part2, input)
        assertEquals(5, actual)
    }

    @Test
    fun `part two solution`() {
        val actual = Day1.execute(::part2)
        assertEquals(1781, actual)
    }

    companion object {
        private val input = """
            199
            200
            208
            210
            200
            207
            240
            269
            260
            263
            """.trimIndent()
    }
}