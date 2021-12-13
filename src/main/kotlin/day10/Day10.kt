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
    }.map(Char::score).reduce(Int::plus)

    override fun part2(input: Sequence<String>): Any {
        TODO("Not yet implemented")
    }
}

private val openToClose = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>')

private fun Char.score() = when {
    this == ')' -> 3
    this == ']' -> 57
    this == '}' -> 1197
    this == '>' -> 25137
    else -> 0
}