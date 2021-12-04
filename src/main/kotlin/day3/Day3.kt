package com.github.rileymichael.day3

import com.github.rileymichael.Day

object Day3 : Day<DiagnosticReport>(3) {
    override fun parseInput(input: Sequence<String>) = DiagnosticReport(input.toList())

    override fun part1(input: DiagnosticReport) = input.gammaRate * input.epsilonRate

    override fun part2(input: DiagnosticReport) = input.oxygenRating * input.scrubberRating
}