package com.github.rileymichael.day9

import com.github.rileymichael.util.DIRECTIONS
import com.github.rileymichael.util.Point

data class HeightMap(val data: List<List<Int>>) {
    val height = data.indices
    val width = data.first().indices
    operator fun get(point: Point) = data.getOrNull(point.y)?.getOrNull(point.x) ?: 9
}

fun HeightMap.lowPointRiskLevel() = height.sumOf { row ->
    width.sumOf { col ->
        val pos = Point(col, row)
        val neighbors = DIRECTIONS.map { pos + it }
        if (neighbors.all { this[pos] < this[it] }) 1 + this[pos] else 0
    }
}