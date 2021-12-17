package com.github.rileymichael.day11

import com.github.rileymichael.util.Point

class OctopusCavern(private val grid: List<IntArray>) {
    val size = grid.size * grid.first().size
    private val height = grid.indices
    private val width = grid.first().indices
    private val energyRange = 0..9
    private val deltaRange = -1..1

    fun step(): Int {
        val flashes = mutableSetOf<Point>()
        height.forEach { row ->
            width.forEach { column ->
                val pos = Point(column, row)
                if (pos !in flashes) {
                    grid[pos].increaseEnergy().run {
                        grid[pos] = this
                        if (flashed()) {
                            flashes.add(pos)
                            updateNeighbours(pos, flashes)
                        }
                    }
                }
            }
        }
        return flashes.size
    }

    private fun updateNeighbours(point: Point, flashes: MutableSet<Point>) {
        deltaRange.flatMap { deltaX ->
            deltaRange.map { deltaY ->
                Point(point.x + deltaX, point.y + deltaY)
            }
        }.filter {
            it.x in width && it.y in height
        }.forEach {
            if (it !in flashes) {
                grid[it].increaseEnergy().run {
                    grid[it] = this
                    if (flashed()) {
                        flashes.add(it)
                        updateNeighbours(it, flashes)
                    }
                }
            }
        }
    }

    private operator fun List<IntArray>.get(point: Point): Int {
        require(point.y in height) { "y out of bounds: $point" }
        require(point.x in width) { "x out of bounds: $point" }
        return this[point.y][point.x]
    }

    private operator fun List<IntArray>.set(point: Point, value: Int) {
        require(point.y in height) { "y out of bounds: $point" }
        require(point.x in width) { "x out of bounds: $point" }
        require(value in energyRange) { "value out of energy range range: $value" }
        this[point.y][point.x] = value
    }

    private fun Int.increaseEnergy() = if (this == 9) 0 else this.inc()
    private fun Int.flashed() = this == 0
}

