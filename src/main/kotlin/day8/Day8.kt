package com.github.rileymichael.day8

import com.github.rileymichael.Day

object Day8 : Day<Sequence<String>>(8) {

    override fun parseInput(input: Sequence<String>) = input
        .flatMap { it.split("|").drop(1) }
        .flatMap { it.split(" ") }

    // #1 = 2 unique segments
    // #4 = 4 unique segments
    // #7 = 3 unique segments
    // #8 = 7 unique segments
    override fun part1(input: Sequence<String>) = input.count { it.length in setOf(2, 4, 3, 7) }

    override fun part2(input: Sequence<String>) = ""
}