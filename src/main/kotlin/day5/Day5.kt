package com.github.rileymichael.day5

import com.github.rileymichael.Day

object Day5 : Day<VentField>(5) {
    override fun parseInput(input: Sequence<String>): VentField {
        val ventLines = input.flatMap { line ->
            line.split("->").flatMap { it.trim().split(",", limit = 2).map(String::toInt) }
                .chunked(2).map { (x, y) -> Point(x, y) }.chunked(2).map { (p1, p2) -> VentLine(p1, p2) }
        }.toList()
        return VentField(ventLines)
    }

    override fun part1(input: VentField) = input.getOverlaps(2) {
        it.isHorizontal || it.isVertical
    }

    override fun part2(input: VentField) = input.getOverlaps(2) {
        it.isHorizontal || it.isVertical || it.isDiagonal
    }
}