package com.github.rileymichael.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {

    @Test
    fun `test parse`() {
        val actual = Day1.parseInput(sequenceOf("1", "2", "3"))
        assertEquals(listOf(1, 2, 3), actual.toList())
    }

    @Test
    fun `test part one`() {
        val actual = Day1.part1(input)
        assertEquals(7, actual)
    }

    @Test
    fun `test part two`() {
        val actual = Day1.part2(input)
        assertEquals(5, actual)
    }

    companion object {
        private val input = sequenceOf(
            199,
            200,
            208,
            210,
            200,
            207,
            240,
            269,
            260,
            263
        )
    }
}