package com.github.rileymichael.day7

import com.github.rileymichael.Day
import kotlin.math.abs

object Day7: Day<List<Int>>(7) {
    override fun parseInput(input: Sequence<String>): List<Int> = input.first().split(",").map(String::toInt)

    override fun part1(input: List<Int>): Int {
        val min = input.minByOrNull { it } ?: error("No minimum found")
        val max = input.maxByOrNull { it } ?: error("No maximum found")
        return (min..max).minOf { pos ->
            input.sumOf { abs(it - pos) }
        }
    }

    override fun part2(input: List<Int>): Any {
        TODO("Not yet implemented")
    }

}