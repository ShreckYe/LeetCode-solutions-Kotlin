import kotlin.test.assertContentEquals

class Solution {
    data class SumFromC1(val c1: Int, val sum: Long)

    fun getMaxMatrix(matrix: Array<IntArray>): IntArray {
        val m = matrix.size
        val n = matrix.first().size

        // empty submatrices not allowed
        val prefixSumsAtC = Array(n) { c ->
            (0 until m).map { r -> matrix[r][c] }.runningFold(0L) { acc, n -> acc + n }
        }

        val maxWithR1R2C2 = Array(m) { Array(m) { Array<SumFromC1?>(n) { null } } }
        for (r1 in 0 until m)
            for (r2 in r1 until m) {
                val maxWithC2 = maxWithR1R2C2[r1][r2]
                for (c2 in 0 until n) {
                    val columnSum = prefixSumsAtC[c2].let { it[r2 + 1] - it[r1] }
                    val column = SumFromC1(c2, columnSum)
                    maxWithC2[c2] =
                        if (c2 == 0) column
                        else maxWithC2[c2 - 1]!!.let {
                            if (it.sum > 0) SumFromC1(it.c1, it.sum + columnSum) else column
                        }
                }
            }

        return maxWithR1R2C2.asSequence().withIndex().flatMap { (r1, array) ->
            array.asSequence().withIndex()
                .drop(r1)
                .flatMap { (r2, array) ->
                    array.asSequence() // for LeetCode's Kotlin version
                        .mapIndexed { c2, sumFromC1 ->
                            intArrayOf(r1, sumFromC1!!.c1, r2, c2) to sumFromC1.sum
                        }
                }
        }.maxByOrNull { it.second }!!.first // for LeetCode's Kotlin version
        //.maxByOrNull { it.second }!!.first
    }

    /** Adapted from [kotlin.collections.runningFold] for LeetCode's Kotlin version. */
    inline fun <T, R> List<T>.runningFold(initial: R, operation: (acc: R, T) -> R): List<R> {
        val size = size
        if (size == 0) return listOf(initial)
        val result = ArrayList<R>(size + 1).apply { add(initial) }
        var accumulator = initial
        for (element in this) {
            accumulator = operation(accumulator, element)
            result.add(accumulator)
        }
        return result
    }
}

val solution = Solution()

// question sample
assertContentEquals(
    intArrayOf(0, 1, 0, 1),
    solution.getMaxMatrix(
        arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(0, -1)
        )
    )
)

// my own tests
assertContentEquals(
    intArrayOf(0, 0, 0, 0),
    solution.getMaxMatrix(arrayOf(intArrayOf(1)))
)

assertContentEquals(
    intArrayOf(1, 1, 1, 1),
    solution.getMaxMatrix(Array(3) { IntArray(3) { -1 } }.also { it[1][1] = 1 })
)
