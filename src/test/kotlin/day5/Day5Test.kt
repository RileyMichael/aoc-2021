package com.github.rileymichael.day5

import com.github.rileymichael.day5.Day5.part1
import com.github.rileymichael.day5.Day5.part2
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day5Test {
    @Test
    fun `part one example`() {
        val actual = Day5.execute(::part1, input)
        Assertions.assertEquals(5, actual)
    }

    @Test
    fun `part one solution`() {
        val actual = Day5.execute(::part1)
        Assertions.assertEquals(5608, actual)
    }

    @Test
    fun `part two example`() {
        val actual = Day5.execute(::part2, input)
        Assertions.assertEquals(12, actual)
    }

    @Test
    fun `part two solution`() {
        val actual = Day5.execute(::part2)
        Assertions.assertEquals(20299, actual)
    }

    companion object {
        private val input = """
0,9 -> 5,9
8,0 -> 0,8
9,4 -> 3,4
2,2 -> 2,1
7,0 -> 7,4
6,4 -> 2,0
0,9 -> 2,9
3,4 -> 1,4
0,0 -> 8,8
5,5 -> 8,2
        """.trimIndent()
    }
}