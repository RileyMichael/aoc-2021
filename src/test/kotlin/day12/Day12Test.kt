package com.github.rileymichael.day12

import com.github.rileymichael.day12.Day12.part1
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day12Test {

    @ParameterizedTest
    @MethodSource("input")
    fun `part one example`(input: String, expected: Int) {
        val actual = Day12.execute(::part1, input)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `part one solution`() {
        val actual = Day12.execute(::part1)
        Assertions.assertEquals(3463, actual)
    }

    companion object {
        @JvmStatic
        private fun input() = listOf(
            Arguments.of(
                """
                start-A
                start-b
                A-c
                A-b
                b-d
                A-end
                b-end
                """.trimIndent(),
                10
            ),
            Arguments.of(
                """
                dc-end
                HN-start
                start-kj
                dc-start
                dc-HN
                LN-dc
                HN-end
                kj-sa
                kj-HN
                kj-dc
                """.trimIndent(),
                19
            ),
            Arguments.of(
                """
                fs-end
                he-DX
                fs-he
                start-DX
                pj-DX
                end-zg
                zg-sl
                zg-pj
                pj-he
                RW-he
                fs-DX
                pj-RW
                zg-RW
                start-pj
                he-WI
                zg-he
                pj-fs
                start-RW
                """.trimIndent(),
                226
            )
        )
    }

}