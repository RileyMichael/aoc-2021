package com.github.rileymichael.day2

import com.github.rileymichael.day2.Day2.part1
import com.github.rileymichael.day2.Day2.part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun `part one example`() {
        val actual = Day2.execute(::part1, input)
        assertEquals(150, actual)
    }

    @Test
    fun `part one solution`() {
        val actual = Day2.execute(::part1)
        assertEquals(1484118, actual)
    }

    @Test
    fun `part two example`() {
        val actual = Day2.execute(::part2, input)
        assertEquals(900, actual)
    }

    @Test
    fun `part two solution`() {
        val actual = Day2.execute(::part2)
        assertEquals(1463827010, actual)
    }

    companion object {
        private val input = """
            forward 5
            down 5
            forward 8
            up 3
            down 8
            forward 2
        """.trimIndent()
    }
}