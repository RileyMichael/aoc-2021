package com.github.rileymichael.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

    @Test
    fun `test parse`() {
        val actual = Day3.parseInput(sequenceOf("011", "111"))
        assertEquals(DiagnosticReport(listOf("011", "111")), actual)
    }

    @Test
    fun `test part one`() {
        val actual = Day3.part1(input)
        assertEquals(198, actual)
    }

    @Test
    fun `test part two`() {
        val actual = Day3.part2(input)
        assertEquals(230, actual)
    }

    companion object {
        private val input = DiagnosticReport(
            listOf(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010",
            )
        )
    }
}