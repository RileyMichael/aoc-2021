package com.github.rileymichael.day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun `test parse`() {
        val actual = Day2.parseInput(sequenceOf("forward 5", "down 1"))
        assertEquals(listOf(Command("forward", 5), Command("down", 1)), actual.toList())
    }

    @Test
    fun `test part one`() {
        val actual = Day2.part1(input)
        assertEquals(150, actual)
    }

    @Test
    fun `test part two`() {
        val actual = Day2.part2(input)
        assertEquals(900, actual)
    }

    companion object {
        private val input = sequenceOf(
            Command("forward",  5),
            Command("down", 5),
            Command("forward", 8),
            Command("up", 3),
            Command("down", 8),
            Command("forward", 2),
        )
    }
}