package com.github.rileymichael.day9

import com.github.rileymichael.util.DIRECTIONS
import com.github.rileymichael.util.Point

data class HeightMap(val data: List<List<Int>>) {
    private val height = data.indices
    private val width = data.first().indices

    val lowPoints by lazy {
        height.flatMap { row ->
            width.mapNotNull { col ->
                val pos = Point(col, row)
                val neighbors = DIRECTIONS.map { pos + it }
                if (neighbors.all { this[pos] < this[it] }) pos else null
            }
        }
    }

    val basins by lazy { lowPoints.map { expand(it) } }

    operator fun get(point: Point) = data.getOrNull(point.y)?.getOrNull(point.x) ?: 9
}

fun HeightMap.lowPointRiskLevel() = lowPoints.sumOf { this[it] + 1 }

fun HeightMap.expand(point: Point, visited: MutableSet<Point> = mutableSetOf()): MutableSet<Point> {
    if (this[point] == 9 || point in visited) return visited
    visited += point
    DIRECTIONS.map { point + it }.forEach { expand(it, visited) }
    return visited
}