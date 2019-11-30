package shreckye.leetcode

class Solution {
    // Sort and compare one by one
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val sortedIndexedNums = nums.withIndex().sortedBy(IndexedValue<Int>::value)
        var i = 0
        var j = nums.size - 1
        while (i < j) {
            val left = sortedIndexedNums[i]
            val right = sortedIndexedNums[j]
            val sum = left.value + right.value

            if (sum == target) return intArrayOf(left.index, right.index)
            if (sum < target) ++i
            else --j
        }
        throw IllegalArgumentException()
    }
}