package shreckye.leetcode

import kotlin.math.min

// Manacher's Algorithm
class Solution {
    fun longestPalindrome(s: String): String {
        val lastPosition = 2 * s.length
        val numPositions = lastPosition + 1
        val longestPalindromeLengthsCenteredAt = IntArray(numPositions)

        var rightmostPalindromeCenter = 0
        // Always even
        var rightmostPalindromeRight = 0

        var longestPalindromeCenter = 0
        var longestPalindromeLength = 0
        longestPalindromeLengthsCenteredAt[0] = 0
        for (i in 1 until numPositions) {
            val symmetricPalindromeLength =
                longestPalindromeLengthsCenteredAt.getOrElse(rightmostPalindromeCenter * 2 - i) { 0 }
            val lengthAtI: Int
            if (i + symmetricPalindromeLength < rightmostPalindromeRight)
                lengthAtI = symmetricPalindromeLength
            else {
                val minPossibleLength = rightmostPalindromeRight - i
                lengthAtI = (minPossibleLength + 2..min(i, lastPosition - i) step 2).asSequence()
                    // (i * 2 - it) / 2 = i - it / 2 - 1
                    .takeWhile { s[(i - it) / 2] == s[(i + it) / 2 - 1] }.lastOrNull() ?: minPossibleLength

                rightmostPalindromeCenter = i
                rightmostPalindromeRight = i + lengthAtI
            }

            longestPalindromeLengthsCenteredAt[i] = lengthAtI
            if (lengthAtI > longestPalindromeLength) {
                longestPalindromeCenter = i
                longestPalindromeLength = lengthAtI
            }
        }

        return s.substring(
            (longestPalindromeCenter - longestPalindromeLength) / 2,
            (longestPalindromeCenter + longestPalindromeLength) / 2
        )
    }
}