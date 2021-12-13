package com.github.rileymichael.util

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
}

val DIRECTIONS = listOf(
    Point(0, 1),
    Point(1, 0),
    Point(0, -1),
    Point(-1, 0)
)
