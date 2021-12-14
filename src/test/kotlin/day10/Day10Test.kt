package com.github.rileymichael.day10

import com.github.rileymichael.day10.Day10.part1
import com.github.rileymichael.day10.Day10.part2
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day10Test {
    @Test
    fun `part one example`() {
        val actual = Day10.execute(::part1, input)
        Assertions.assertEquals(26397, actual)
    }

    @Test
    fun `part one solution`() {
        val actual = Day10.execute(::part1)
        Assertions.assertEquals(469755, actual)
    }

    @Test
    fun `part two example`() {
        val actual = Day10.execute(::part2, input)
        Assertions.assertEquals(288957L, actual)
    }

    @Test
    fun `part two solution`() {
        val actual = Day10.execute(::part2)
        Assertions.assertEquals(2762335572L, actual)
    }

    companion object {
        private val input = """
            [({(<(())[]>[[{[]{<()<>>
            [(()[<>])]({[<{<<[]>>(
            {([(<{}[<>[]}>{[]{[(<()>
            (((({<>}<{<{<>}{[]{[]{}
            [[<[([]))<([[{}[[()]]]
            [{[{({}]{}}([{[{{{}}([]
            {<[[]]>}<{[{[{[]{()[[[]
            [<(<(<(<{}))><([]([]()
            <{([([[(<>()){}]>(<<{{
            <{([{{}}[<[[[<>{}]]]>[]]
        """.trimIndent()
    }
}