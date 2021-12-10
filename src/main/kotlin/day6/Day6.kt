package com.github.rileymichael.day6

import com.github.rileymichael.Day

data class LanternfishSchool(val initialTimers: Sequence<Int>) {
    private var fish = initialTimers.groupingBy { it }.eachCount().run {
        LongArray(9) { getOrDefault(it, 0).toLong() }
    }

    fun simulate(days: Int) = repeat(days) {
        val new = fish[0]
        fish.indices.forEach { fish[it] = fish.getOrElse(it + 1) { new } }
        fish[6] = fish[6] + new
    }.run { fish.sum() }
}

object Day6 : Day<LanternfishSchool>(6) {
    override fun parseInput(input: Sequence<String>) = input.flatMap {
        it.split(",").map(String::toInt)
    }.run { LanternfishSchool(this) }

    override fun part1(input: LanternfishSchool) = input.simulate(80)

    override fun part2(input: LanternfishSchool): Any {
        TODO("Not yet implemented")
    }
}