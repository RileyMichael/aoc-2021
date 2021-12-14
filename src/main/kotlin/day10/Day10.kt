package com.github.rileymichael.day10

import com.github.rileymichael.Day

object Day10 : Day<Sequence<String>>(10) {
    override fun parseInput(input: Sequence<String>): Sequence<String> = input

    override fun part1(input: Sequence<String>) = input.mapNotNull line@{ line ->
        val stack = mutableListOf<Char>()
        line.forEach { c ->
            when (c) {
                in openToClose.keys -> stack.add(c)
                else -> {
                    val prev = stack.removeLast()
                    if (openToClose[prev] != c) {
                        return@line c
                    }
                }
            }
        }
        null
    }.map(Char::corruptedScore).reduce(Int::plus)

    override fun part2(input: Sequence<String>): Long {
        val completionStrings = input.mapNotNull line@{ line ->
            val stack = mutableListOf<Char>()
            line.forEach { c ->
                when (c) {
                    in openToClose.keys -> stack.add(c)
                    else -> {
                        val prev = stack.removeLast()
                        if (openToClose[prev] != c) {
                            return@line null
                        }
                    }
                }
            }
            stack.toCompletionString()
        }
        return completionStrings.map {
            it.map(Char::incompleteScore).reduce { acc, i -> acc * 5 + i }
        }.toList().sorted().middle()
    }
}

private val openToClose = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>')
private fun MutableList<Char>.toCompletionString() = this.reversed().map { openToClose[it] }.joinToString("")
private fun <T> List<T>.middle() = this.elementAt(this.size / 2)

private fun Char.corruptedScore() = when {
    this == ')' -> 3
    this == ']' -> 57
    this == '}' -> 1197
    this == '>' -> 25137
    else -> 0
}

private fun Char.incompleteScore() = when {
    this == ')' -> 1L
    this == ']' -> 2L
    this == '}' -> 3L
    this == '>' -> 4L
    else -> 0L
}