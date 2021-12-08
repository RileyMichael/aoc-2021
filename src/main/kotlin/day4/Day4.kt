package com.github.rileymichael.day4

import com.github.rileymichael.Day

data class BingoGame(val numbers: List<Int>, val boards: List<BingoBoard>)

object Day4 : Day<BingoGame>(4) {
    override fun parseInput(input: Sequence<String>): BingoGame = input.iterator().run {
        val numbers = next().split(",").map(String::toInt)
        val boards = asSequence().drop(1).filter(String::isNotEmpty).chunked(5).map { row ->
            row.map {
                it.split(" ").mapNotNull(String::toIntOrNull)
            }
        }.map { BingoBoard(it) }.toList()
        return BingoGame(numbers, boards)
    }

    override fun part1(input: BingoGame): Int {
        input.numbers.forEachIndexed { index, _ ->
            val numbers = input.numbers.take(index + 1)
            input.boards.firstOrNull { it.isBingo(numbers) }?.let { winner ->
                return winner.score(numbers)
            }
        }
        return 0
    }

    override fun part2(input: BingoGame): Int {
        var boards = input.boards.toSet()
        input.numbers.forEachIndexed { index, _ ->
            val numbers = input.numbers.take(index + 1)
            val bingos = boards.filter { it.isBingo(numbers) }.toSet()
            boards = boards.minus(bingos)
            if (boards.isEmpty()) {
                return bingos.first().score(numbers)
            }
        }
        return 0
    }
}