package com.github.rileymichael.day9

import com.github.rileymichael.day9.Day9.part1
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day9Test {

    @Test
    fun `part one example`() {
        val actual = Day9.execute(::part1, input)
        Assertions.assertEquals(15, actual)
    }

    @Test
    fun `part one solution`() {
        val actual = Day9.execute(::part1)
        Assertions.assertEquals(425, actual)
    }

    companion object {
        private val input = """
            2199943210
            3987894921
            9856789892
            8767896789
            9899965678
        """.trimIndent()
    }
}