package com.github.rileymichael.day12

import com.github.rileymichael.Day


object Day12 : Day<CaveSystem>(12) {
    override fun parseInput(input: Sequence<String>): CaveSystem = buildMap {
        input.forEach { line ->
            val (name, connecting) = line.split("-")
            put(name, getOrDefault(name, emptySet()).plus(connecting))
            put(connecting, getOrDefault(connecting, emptySet()).plus(name))
        }
    }

    override fun part1(input: CaveSystem) = input.search().size

    override fun part2(input: CaveSystem): Any {
        TODO("Not yet implemented")
    }
}

typealias Cave = String
typealias CaveSystem = Map<Cave, Set<Cave>>
typealias Path = List<Cave>

private fun CaveSystem.search(
    cave: Cave = "start",
    path: Path = listOf("start")
): Set<Path> = when (cave) {
    "end" -> setOf(path)
    else -> getOrDefault(cave, emptySet())
        .filter { it.all(Char::isUpperCase) || it !in path }
        .flatMap { search(it, path + it) }.toSet()
}