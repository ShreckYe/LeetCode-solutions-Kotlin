package shreckye.leetcode

// This solution is used to test whether LeetCode counts evaluation time in the runtime. The answer is yes.
class Solution {
    fun permute(nums: IntArray): List<List<Int>> =
        permute(nums.asSequence()).map { it.asList() }.asList()

    fun permute(numSequence: Sequence<Int>): Sequence<Sequence<Int>> =
        if (numSequence.none()) sequenceOf(emptySequence())
        else {
            val nums = numSequence.toList()
            nums.asSequence().withIndex().flatMap { (i, num) ->
                permute(nums.subList(0, i).asSequence() + nums.subList(i + 1, nums.size).asSequence())
                    .map { sequenceOf(num) + it }
            }
        }

    class SequenceLazyList<T>(val sequence: Sequence<T>) : AbstractList<T>() {
        val list: List<T> by lazy { sequence.toList() }
        override val size: Int
            get() = list.size

        override fun get(index: Int): T =
            list[index]
    }

    fun <T> Sequence<T>.asList(): List<T> =
        SequenceLazyList(this)
}