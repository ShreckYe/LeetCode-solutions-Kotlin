class Solution {
    fun permute(nums: IntArray): List<List<Int>> =
        permuteSequence(nums.asList()).map(Sequence<Int>::toList).toList()

    // using sequences for [nums] increases overhead here because it has to be converted to a list to be reused.
    fun permuteSequence(nums: List<Int>): Sequence<Sequence<Int>> =
        if (nums.isEmpty()) sequenceOf(emptySequence())
        else nums.asSequence().withIndex().flatMap { (i, num) ->
            permuteSequence(nums.subList(0, i) + nums.subList(i + 1, nums.size)).map { sequenceOf(num) + it }
        }
}