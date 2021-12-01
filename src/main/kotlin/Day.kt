package com.github.rileymichael

abstract class Day<T>(val number: Int) {
    abstract fun parseInput(input: Sequence<String>): T
    abstract fun part1(input: T): Any
    abstract fun part2(input: T): Any
}