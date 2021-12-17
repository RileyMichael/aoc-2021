package com.github.rileymichael.day12

import com.github.rileymichael.day12.Day12.part1
import com.github.rileymichael.day12.Day12.part2
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day12Test {

    @ParameterizedTest
    @MethodSource("part1")
    fun `part one example`(input: String, expected: Int) {
        val actual = Day12.execute(::part1, input)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `part one solution`() {
        val actual = Day12.execute(::part1)
        Assertions.assertEquals(3463, actual)
    }

    @ParameterizedTest
    @MethodSource("part2")
    fun `part two example`(input: String, expected: Int) {
        val actual = Day12.execute(::part2, input)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `part two solution`() {
        val actual = Day12.execute(::part2)
        Assertions.assertEquals(91533, actual)
    }

    companion object {
        @JvmStatic
        private fun part1() = listOf(
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

        @JvmStatic
        private fun part2() = listOf(
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
                36
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
                103
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
                3509
            )
        )
    }

}