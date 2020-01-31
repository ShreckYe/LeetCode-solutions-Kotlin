package shreckye.leetcode

import kotlin.test.assertEquals

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSumEndingAtI = Int.MIN_VALUE
        var maxSum = Int.MIN_VALUE
        for (num in nums) {
            maxSumEndingAtI = if (maxSumEndingAtI > 0) maxSumEndingAtI + num else num
            if (maxSumEndingAtI > maxSum) maxSum = maxSumEndingAtI
        }

        return maxSum
    }
}


// Tests
val solution = Solution()
assertEquals(solution.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)), 6)
assertEquals(solution.maxSubArray(intArrayOf(-1)), -1)