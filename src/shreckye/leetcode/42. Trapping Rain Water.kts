package shreckye.leetcode

import kotlin.math.min
import kotlin.test.assertEquals

class Solution {
    fun trap(height: IntArray): Int {
        val size = height.size
        val leftMaxHeights = IntArray(size)
        val rightMaxHeights = IntArray(size)

        var leftMaxHeight = 0
        //for ((i, h) in height.withIndex()) {
        for (i in 0 until size) {
            val h = height[i]
            leftMaxHeights[i] = leftMaxHeight
            if (h > leftMaxHeight)
                leftMaxHeight = h
        }

        var rightMaxHeight = 0
        //for ((i, h) in height.withIndex().reversed()) {
        for (i in size - 1 downTo 0) {
            val h = height[i]
            rightMaxHeights[i] = rightMaxHeight
            if (h > rightMaxHeight)
                rightMaxHeight = h
        }

        return (0 until size).sumBy { i ->
            val waterHeight = min(leftMaxHeights[i], rightMaxHeights[i])
            val barHeight = height[i]
            if (waterHeight > barHeight) waterHeight - barHeight else 0
        }
    }
}


// Tests
val trap = Solution()::trap
assertEquals(6, trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))