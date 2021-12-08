package com.github.rileymichael.day4

data class BingoBoard(val grid: List<List<Int>>) {
    fun isBingo(numbers: List<Int>): Boolean {
        val rowWin = grid.any { row ->
            row.all { it in numbers }
        }
        val columnWin = grid.indices.any { i ->
            grid.map { it[i] }.all { it in numbers }
        }
        return rowWin || columnWin
    }

    fun score(numbers: List<Int>): Int = grid.sumOf { row ->
        row.filter { !numbers.contains(it) }.sum()
    } * numbers.last()
}