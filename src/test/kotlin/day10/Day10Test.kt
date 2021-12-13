package com.github.rileymichael.day10

import com.github.rileymichael.day10.Day10.part1
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