package shreckye.leetcode

class Solution {
    // Use a hash map
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numMap = HashMap<Int, Int>(nums.size)
        for ((i, num) in nums.withIndex()) {
            val complement = target - num
            if (numMap.containsKey(complement)) return intArrayOf(numMap[complement]!!, i)
            numMap[num] = i
        }
        throw IllegalArgumentException()
    }
}