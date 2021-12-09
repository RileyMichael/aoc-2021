package com.github.rileymichael.day5

import kotlin.math.max
import kotlin.math.min

data class VentLine(val p1: Point, val p2: Point) {
    fun isHorizontal() = p1.y == p2.y
    fun isVertical() = p1.x == p2.x
    fun points(): List<Point> {
        val points = mutableListOf<Point>()
        if (isHorizontal()) {
            for (x in min(p1.x, p2.x)..max(p1.x, p2.x)) {
                points.add(Point(x, p1.y))
            }
        } else if (isVertical()) {
            for (y in min(p1.y, p2.y)..max(p1.y, p2.y)) {
                points.add(Point(p1.x, y))
            }
        }
        return points
    }
}