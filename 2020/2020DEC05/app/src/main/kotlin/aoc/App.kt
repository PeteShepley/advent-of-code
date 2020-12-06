package aoc

import java.io.File

class App {
}

fun parseBoardingPassId(passId: String): Int {
    val converted = convert(passId)
    return parseBinaryId(converted)
}

fun parseBinaryId(id: String): Int {
    val row = id.slice(0..6).toInt(2)
    val col = id.slice(7..9).toInt(2)
    return (row * 8) + col
}

fun convert(s: String): String {
    val converted = s.map {
        when (it) {
            'F' -> '0'
            'B' -> '1'
            'L' -> '0'
            'R' -> '1'
            else -> '0'
        }
    }
    return converted.joinToString("")
}

fun main(args: Array<String>) {
    val resource = App::class.java.classLoader.getResource("input")
    val input = File(resource.file).useLines { it.toList() }
    val passIds = input.map { parseBoardingPassId(it) }
    val maxId = passIds.max()
    println("Biggest boarding pass ID: $maxId")

    val sortedIds = passIds.sorted()
    val candidates = mutableListOf<Int>()
    for (i in sortedIds.indices) {
        if (i != sortedIds.lastIndex) {
            if (sortedIds.get(i + 1) - sortedIds.get(i) > 1) {
                candidates.add(sortedIds.get(i) + 1)
            }
        }
    }
    println(candidates)
}
