package com.github.rileymichael.day5

import kotlin.math.max
import kotlin.math.min

data class VentLine(var p1: Point, var p2: Point) {
    val isHorizontal: Boolean
        get() = p1.y == p2.y

    val isVertical: Boolean
        get() = p1.x == p2.x

    val isDiagonal: Boolean
        get() = p1.x != p2.x && p1.y != p2.y

    val points: List<Point>
        get() = when {
            isVertical -> {
                val minY = min(p1.y, p2.y)
                val maxY = max(p1.y, p2.y)
                (minY..maxY).map { y ->
                    Point(p1.x, y)
                }
            }
            else -> {
                if (p1.x > p2.x) {
                    p1 = p2.also { p2 = p1 }
                }
                (p1.x..p2.x).map { x ->
                    val y = p1.y + (p2.y - p1.y) * (x - p1.x) / (p2.x - p1.x)
                    Point(x, y)
                }
            }
        }
}
