package com.github.rileymichael.day1

import com.github.rileymichael.Day

object Day1: Day<Sequence<Int>>(1) {
    override fun parseInput(input: Sequence<String>): Sequence<Int> {
        return input.map(String::toInt)
    }

    override fun part1(input: Sequence<Int>): Any {
        return input.reduce { acc, i -> acc + i }
    }

    override fun part2(input: Sequence<Int>): Any {
        return input.reduce { acc, i -> acc * i }
    }
}