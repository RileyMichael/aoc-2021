package com.github.rileymichael.day2

import com.github.rileymichael.Day

data class Command(val direction: String, val amount: Int)

object Day2 : Day<Sequence<Command>>(2) {
    override fun parseInput(input: Sequence<String>) = input.map {
        it.split(" ").let { (a, b) -> Command(a, b.toInt()) }
    }

    override fun part1(input: Sequence<Command>): Any {
        var (depth, pos) = Pair(0,0)
        input.forEach { command ->
            when (command.direction) {
                "forward" -> pos = pos.plus(command.amount)
                "down" -> depth = depth.plus(command.amount)
                "up" -> depth = depth.minus(command.amount)
            }
        }
        return depth * pos
    }

    override fun part2(input: Sequence<Command>): Any {
        var (depth, pos, aim) = Triple(0, 0, 0)
        input.forEach { command ->
            when (command.direction) {
                "forward" -> {
                    pos = pos.plus(command.amount)
                    depth = depth.plus(aim * command.amount)
                }
                "down" -> aim = aim.plus(command.amount)
                "up" -> aim = aim.minus(command.amount)
            }
        }
        return depth * pos
    }
}