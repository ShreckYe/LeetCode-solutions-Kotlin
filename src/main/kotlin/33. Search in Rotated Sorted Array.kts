import kotlin.test.assertEquals

class Solution {
    fun search(nums: IntArray, target: Int): Int =
        search(nums, 0, nums.size - 1, target)

    fun search(nums: IntArray, lowIndex: Int, highIndex: Int, target: Int): Int =
        when (highIndex - lowIndex) {
            -1 -> -1
            0 -> if (target == nums[lowIndex]) lowIndex else -1
            else -> { // size >= 2
                val lowNum = nums[lowIndex]
                val highNum = nums[highIndex]
                val midIndex = (lowIndex + highIndex) shr 1
                val midNum = nums[midIndex]
                when {
                    midNum >= lowNum ->
                        if (target in lowNum..midNum) nums.binarySearch(target, lowIndex, midIndex + 1)
                        else /*if (target < lowNum || target > midNum)*/ search(nums, midIndex + 1, highIndex, target)
                    midNum <= highNum ->
                        if (target in midNum..highNum) nums.binarySearch(target, midIndex, highIndex + 1)
                        else search(nums, lowIndex, midIndex - 1, target)
                    else -> throw IllegalArgumentException()
                }
            }
        }

}

// Tests:
assertEquals(-1, Solution().search(intArrayOf(1, 3, 5), 2))