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
        val actual = Day1.part1(sequenceOf(1, 2, 3))
        assertEquals(6, actual)
    }

    @Test
    fun `test part two`() {
        val actual = Day1.part2(sequenceOf(2, 5))
        assertEquals(10, actual)
    }
}