package com.github.rileymichael.day5

data class VentField(val lines: List<VentLine>) {
    fun getOverlaps(overlapAmount: Int, filter: (VentLine) -> Boolean): Int {
        val field = lines.filter(filter).flatMap(VentLine::points).groupingBy { it }.eachCount()
        return field.count { it.value >= overlapAmount }
    }
}