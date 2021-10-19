class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> =
        permuteSequence(nums.asList()).map(Sequence<Int>::toList).toList()

    fun permuteSequence(nums: List<Int>): Sequence<Sequence<Int>> =
        if (nums.isEmpty()) sequenceOf(emptySequence())
        else nums.asSequence().withIndex().distinctBy { it.value }.flatMap { (i, num) ->
            permuteSequence(nums.subList(0, i) + nums.subList(i + 1, nums.size)).map { sequenceOf(num) + it }
        }
}