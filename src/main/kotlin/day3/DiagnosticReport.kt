package com.github.rileymichael.day3

sealed interface Frequency {
    object LeastCommon : Frequency
    object MostCommon : Frequency
}

data class DiagnosticReport(val input: List<String>) {
    private val bits = input.firstOrNull()?.length ?: 0
    private val bitRange = (0 until bits)

    val gammaRate by lazy { frequencyCount(Frequency.MostCommon) }

    val epsilonRate by lazy { frequencyCount(Frequency.LeastCommon) }

    val oxygenRating by lazy { filterByBitCriteria(Frequency.MostCommon) }

    val scrubberRating by lazy { filterByBitCriteria(Frequency.LeastCommon) }

    private fun frequencyCount(frequency: Frequency) = bitRange.mapIndexed { index, _ ->
        val counts = input.groupingBy { it[index] }.eachCount()
        when (frequency) {
            Frequency.LeastCommon -> counts.minByOrNull { it.value }
            Frequency.MostCommon -> counts.maxByOrNull { it.value }
        }?.key
    }.joinToString("").toInt(2)

    private fun filterByBitCriteria(frequency: Frequency): Int {
        var remaining = input
        bitRange.forEachIndexed { index, _ ->
            val counts = remaining.groupingBy { it[index] }.eachCount()
            val filtered = counts.filter {
                when (frequency) {
                    Frequency.LeastCommon -> it.value == counts.values.minOrNull()
                    Frequency.MostCommon -> it.value == counts.values.maxOrNull()
                }
            }
            remaining = remaining.filter {
                if (filtered.size > 1) {
                    when (frequency) {
                        Frequency.LeastCommon -> it[index] == '0'
                        Frequency.MostCommon -> it[index] == '1'
                    }
                } else {
                    it[index] == filtered.keys.first()
                }
            }
        }
        return remaining.first().toInt(2)
    }
}