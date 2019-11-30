package shreckye.leetcode

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var longestSubstringLength = 0
        val lastCharIndices = IntArray(128) { -1 } // current index of character
        // try to extend the range [i, j]
        var i = -1
        for ((j, char) in s.withIndex()) {
            val charInt = char.toInt()
            i = max(i, lastCharIndices[charInt])
            longestSubstringLength = max(longestSubstringLength, j - i)
            lastCharIndices[charInt] = j
        }
        return longestSubstringLength
    }
}