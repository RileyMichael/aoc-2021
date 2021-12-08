package com.github.rileymichael

abstract class Day<T>(val number: Int) {
    fun execute(part: (T) -> Any): Any {
        val input = this::class.java.classLoader.getResourceAsStream("Day$number")
        requireNotNull(input) { "Input for day $number not found" }
        return input
            .bufferedReader()
            .useLines { part(parseInput(it)) }
    }
    fun execute(part: (T) -> Any, input: String): Any = part(parseInput(input.lineSequence()))
    abstract fun parseInput(input: Sequence<String>): T
    abstract fun part1(input: T): Any
    abstract fun part2(input: T): Any
}