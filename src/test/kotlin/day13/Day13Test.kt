package com.github.rileymichael.day13

import com.github.rileymichael.day13.Day13.part1
import com.github.rileymichael.day13.Day13.part2
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day13Test {
    @Test
    fun `part one example`() {
        val actual = Day13.execute(::part1, input)
        Assertions.assertEquals(17, actual)
    }

    @Test
    fun `part one solution`() {
        val actual = Day13.execute(::part1)
        Assertions.assertEquals(724, actual)
    }

    @Test
    fun `part two example`() {
        val actual = Day13.execute(::part2, input)
        Assertions.assertEquals("""
            #####
            #   #
            #   #
            #   #
            #####

            """.trimIndent(), actual)
    }

    @Test
    fun `part two solution`() {
        val actual = Day13.execute(::part2)
        Assertions.assertEquals("""
             ##  ###    ## ###  #### ###  #  # #   
            #  # #  #    # #  # #    #  # #  # #   
            #    #  #    # ###  ###  #  # #  # #   
            #    ###     # #  # #    ###  #  # #   
            #  # #    #  # #  # #    # #  #  # #   
             ##  #     ##  ###  #### #  #  ##  ####

        """.trimIndent(), actual)
    }

    companion object {
        private val input = """
            6,10
            0,14
            9,10
            0,3
            10,4
            4,11
            6,0
            6,12
            4,1
            0,13
            10,12
            3,4
            3,0
            8,4
            1,10
            2,14
            8,10
            9,0

            fold along y=7
            fold along x=5
        """.trimIndent()
    }
}