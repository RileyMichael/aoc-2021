package com.github.rileymichael.day11

import com.github.rileymichael.Day

object Day11: Day<OctopusCavern>(11) {
    override fun parseInput(input: Sequence<String>) = input.map { line ->
        line.map(Char::digitToInt).toIntArray()
    }.toList().run { OctopusCavern(this) }

    override fun part1(input: OctopusCavern) = (0 until 100).sumOf { input.step() }

    override fun part2(input: OctopusCavern): Any {
        TODO("Not yet implemented")
    }
}