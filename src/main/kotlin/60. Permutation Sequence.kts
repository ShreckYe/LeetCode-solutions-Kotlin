class Solution {
    fun getPermutation(n: Int, k: Int): String =
        getPermutation((1..n).toList(), getIndices(n, k - 1).second)

    fun getIndices(n: Int, k: Int): Pair<Int, List<Int>> =
        // LeetCode doesn't compile [to]
        if (n == 1) Pair(k, listOf(0))
        else {
            val (qk, indices) = getIndices(n - 1, k)
            Pair(qk / n, listOf(qk % n) + indices)
        }

    fun getPermutation(nums: List<Int>, indicies: List<Int>): String =
        if (nums.isEmpty()) ""
        else {
            val i = indicies[0]
            ('0' + nums[i]) + getPermutation(
                nums.subList(0, i) + nums.subList(i + 1, nums.size), indicies.subList(1, indicies.size)
            )
        }

    // For LeetCode
    data class Pair<out A, out B>(val first: A, val second: B) {
        override fun toString(): String = "($first, $second)"
    }
}