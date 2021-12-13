package com.github.rileymichael.day9

import com.github.rileymichael.Day

object Day9 : Day<HeightMap>(9) {
    override fun parseInput(input: Sequence<String>) = input.map { line ->
        line.map(Char::digitToInt)
    }.toList().run { HeightMap(this) }

    override fun part1(input: HeightMap) = input.lowPointRiskLevel()

    override fun part2(input: HeightMap): Any {
        TODO("Not yet implemented")
    }
}