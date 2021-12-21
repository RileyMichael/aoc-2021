package com.github.rileymichael.day13

import com.github.rileymichael.Day
import com.github.rileymichael.util.Point
import kotlin.math.abs

data class TransparentPaper(val dots: Set<Point>, val instructions: Set<Point>)

private fun Point.fold(foldPoint: Point) = Point(
    if (x > foldPoint.x) abs(foldPoint.x * 2 - x) else x,
    if (y > foldPoint.y) abs(foldPoint.y * 2 - y) else y,
)

private fun Set<Point>.getCode() = buildString {
    (0..this@getCode.maxOf(Point::y)).forEach { y ->
        (0..this@getCode.maxOf(Point::x)).forEach { x ->
            append(if (contains(Point(x, y))) '#' else ' ')
        }
        appendLine()
    }
}

object Day13 : Day<TransparentPaper>(13) {
    private val foldRegex = "fold along ([xy])=(\\d+)".toRegex()
    override fun parseInput(input: Sequence<String>): TransparentPaper {
        val dots = mutableListOf<Point>()
        val instructions = mutableListOf<Point>()
        input.forEach { line ->
            if (line.isBlank()) return@forEach
            foldRegex.matchEntire(line)?.let { match ->
                val (axis, value) = match.destructured
                val point = when (axis) {
                    "x" -> Point(value.toInt(), 0)
                    "y" -> Point(0, value.toInt())
                    else -> error("Invalid axis: $axis")
                }
                instructions.add(point)
            } ?: run {
                val (x, y) = line.split(",")
                dots.add(Point(x.toInt(), y.toInt()))
            }
        }
        return TransparentPaper(dots.toSet(), instructions.toSet())
    }

    override fun part1(input: TransparentPaper): Int {
        val firstFold = input.instructions.first()
        return input.dots.mapTo(HashSet()) { dot ->
            dot.fold(firstFold)
        }.size
    }

    override fun part2(input: TransparentPaper): String {
        var result: HashSet<Point> = HashSet(input.dots)
        input.instructions.forEach {
            result = result.mapTo(HashSet()) { dot ->
                dot.fold(it)
            }
        }
        return result.getCode()
    }
}