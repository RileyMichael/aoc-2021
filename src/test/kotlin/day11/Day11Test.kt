package com.github.rileymichael.day11

import com.github.rileymichael.day11.Day11.part1
import com.github.rileymichael.day11.Day11.part2
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day11Test {
    @Test
    fun `part one example`() {
        val actual = Day11.execute(::part1, input)
        Assertions.assertEquals(1656, actual)
    }

    @Test
    fun `part one solution`() {
        val actual = Day11.execute(::part1)
        Assertions.assertEquals(1705, actual)
    }

    @Test
    fun `part two example`() {
        val actual = Day11.execute(::part2, input)
        Assertions.assertEquals(195, actual)
    }

    @Test
    fun `part two solution`() {
        val actual = Day11.execute(::part2)
        Assertions.assertEquals(265, actual)
    }

    companion object {
        val input = """
            5483143223
            2745854711
            5264556173
            6141336146
            6357385478
            4167524645
            2176841721
            6882881134
            4846848554
            5283751526
        """.trimIndent()
    }
}