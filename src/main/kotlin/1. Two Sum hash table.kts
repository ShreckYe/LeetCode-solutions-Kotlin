class Solution {
    // Use a hash map
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numMap = HashMap<Int, Int>(nums.size)
        for ((i, num) in nums.withIndex()) {
            val complement = target - num
            val complementIndex = numMap[complement]
            if (complementIndex !== null) return intArrayOf(complementIndex, i)
            numMap[num] = i
        }
        throw IllegalArgumentException()
    }
}