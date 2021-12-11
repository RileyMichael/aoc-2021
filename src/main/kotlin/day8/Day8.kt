package com.github.rileymichael.day8

import com.github.rileymichael.Day
import java.util.*

data class Entry(val signalPatterns: List<SortedSet<Char>>, val output: List<SortedSet<Char>>)

object Day8 : Day<Sequence<Entry>>(8) {

    override fun parseInput(input: Sequence<String>) = input
        .map { it.split("|") }
        .map {
            val patterns = it.first().trim().split(" ").map(String::toSortedSet)
            val output = it.last().trim().split(" ").map(String::toSortedSet)
            Entry(patterns, output)
        }

    override fun part1(input: Sequence<Entry>) = input.sumOf {
        it.output.count { output -> output.size in setOf(2, 4, 3, 7) }
    }

    override fun part2(input: Sequence<Entry>) = input.sumOf { entry ->
        val charsByDigit = buildMap<Int, SortedSet<Char>?> {
            put(1, entry.signalPatterns.firstOrNull { it.size == 2 })
            put(4, entry.signalPatterns.firstOrNull { it.size == 4 })
            put(7, entry.signalPatterns.firstOrNull { it.size == 3 })
            put(8, entry.signalPatterns.firstOrNull { it.size == 7 })

            // 5 segment patterns
            put(2, entry.signalPatterns.firstOrNull { it.size == 5 && get(4)?.intersect(it.toSortedSet())?.size == 2 })
            put(3, entry.signalPatterns.firstOrNull { it.size == 5 && get(1)?.intersect(it.toSortedSet())?.size == 2 })
            put(5, entry.signalPatterns.firstOrNull { it.size == 5 && get(2)?.intersect(it.toSortedSet())?.size == 3 })

            // 6 segment patterns
            put(0, entry.signalPatterns.firstOrNull { it.size == 6 && get(5)?.intersect(it.toSortedSet())?.size == 4 })
            put(6, entry.signalPatterns.firstOrNull { it.size == 6 && get(1)?.intersect(it.toSortedSet())?.size == 1 })
            put(9, entry.signalPatterns.firstOrNull { it.size == 6 && get(4)?.intersect(it.toSortedSet())?.size == 4 })
        }
        val digitByChars = charsByDigit.entries.associateBy({ it.value }) { it.key }
        digitByChars[entry.output[0]]!! * 1000 + digitByChars[entry.output[1]]!! * 100 + digitByChars[entry.output[2]]!! * 10 + digitByChars[entry.output[3]]!!
    }
}