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

    override fun part1(input: CaveSystem) = input.search(filter = part1Filter).size

    override fun part2(input: CaveSystem) = input.search(filter = part2Filter).size
}

typealias Cave = String
typealias CaveSystem = Map<Cave, Set<Cave>>
typealias Path = List<Cave>
typealias PathFilter = (Cave, Path) -> Boolean

fun Cave.isBig() = all { it.isUpperCase() }

val part1Filter = { cave: Cave, path: Path ->
    cave.isBig() || cave !in path
}

val part2Filter = { cave: Cave, path: Path ->
    if (cave == "start") {
        false
    } else {
        cave.isBig() || cave !in path || path.filterNot(Cave::isBig).groupingBy { it }.eachCount().none { it.value > 1 }
    }

}

private fun CaveSystem.search(
    cave: Cave = "start",
    path: Path = listOf("start"),
    filter: PathFilter
): Set<Path> = when (cave) {
    "end" -> setOf(path)
    else -> getOrDefault(cave, emptySet())
        .filter { filter(it, path) }
        .flatMap { search(it, path + it, filter) }.toSet()
}

