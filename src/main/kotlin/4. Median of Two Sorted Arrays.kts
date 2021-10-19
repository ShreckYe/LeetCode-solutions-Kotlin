import kotlin.math.max
import kotlin.math.min

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val totalSize = nums1.size + nums2.size
        val totalMid = totalSize / 2
        val odd = totalSize % 2 == 1

        val longerNums: IntArray
        val shorterNums: IntArray
        if (nums1.size >= nums2.size) {
            longerNums = nums1
            shorterNums = nums2
        } else {
            longerNums = nums2
            shorterNums = nums1
        }

        var left = totalMid - shorterNums.size
        var right = totalMid
        // longer nums partition index
        var midLpi: Int
        var spi: Int
        while (true) {
            midLpi = (left + right) / 2
            // shorter nums partition index
            spi = totalMid - midLpi
            if (longerNums.getOrNull(midLpi - 1)?.let { l ->
                    shorterNums.getOrNull(spi)?.let { r -> l > r }
                } == true)
                right = midLpi - 1
            else if (shorterNums.getOrNull(spi - 1)?.let { l ->
                    longerNums.getOrNull(midLpi)?.let { r -> l > r }
                } == true)
                left = midLpi + 1
            else
                break
        }

        // 2 max/min values can't be retrieved at the same time
        return if (odd)
            min(longerNums.getOrElse(midLpi) { Int.MAX_VALUE }, shorterNums.getOrElse(spi) { Int.MAX_VALUE }).toDouble()
        else
            (max(longerNums.getOrElse(midLpi - 1) { Int.MIN_VALUE }, shorterNums.getOrElse(spi - 1) { Int.MIN_VALUE })
                .toDouble() +
                    min(longerNums.getOrElse(midLpi) { Int.MAX_VALUE }, shorterNums.getOrElse(spi) { Int.MAX_VALUE })
                        .toDouble()) / 2
    }

    /*fun maxOrNull(vararg nums: Int?) =
        nums.filterNotNull().max()

    fun minOrNull(vararg nums: Int?) =
        nums.filterNotNull().min()*/
}