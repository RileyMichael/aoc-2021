package com.github.rileymichael

import org.reflections.Reflections
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
import kotlin.system.exitProcess
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

fun main(args: Array<String>) {
    val implsByDay = Reflections("com.github.rileymichael").getSubTypesOf(Day::class.java).associate { dayImpl ->
        @Suppress("UNCHECKED_CAST")
        val prop = dayImpl.kotlin.memberProperties.find { it.name == "number" } as KProperty1<Any, *>
        val instance = dayImpl.kotlin.objectInstance!!
        val day = prop.get(instance) as Int
        day to instance
    }

    args.firstOrNull()?.let { arg ->
        val day = arg.toIntOrNull()
        requireNotNull(day) { "Arg must be a valid day (integer)" }
        val impl = implsByDay[day]
        requireNotNull(impl) { "Invalid day $day" }
        impl.execute()
        exitProcess(0)
    }

    implsByDay.entries.sortedBy { it.key }.forEach { it.value.execute() }
}

@OptIn(ExperimentalTime::class)
fun <T> Day<T>.execute() {
    val part1 = measureTimedValue { execute(this::part1) }
    val part2 = measureTimedValue { execute(this::part2) }
    println("----Day $number----")
    println("Part1 (${part1.duration}): \n${part1.value}")
    println("Part2 (${part2.duration}): \n${part2.value}")
}