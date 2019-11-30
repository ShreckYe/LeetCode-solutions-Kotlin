package shreckye.leetcode

import kotlin.math.min

class Solution {
    fun longestPalindrome(s: String): String {
        val lastPosition = s.length * 2
        val (center, length) = (0..lastPosition).map { center ->
            center to if (center % 2 == 0)
                (2..min(center, lastPosition - center) step 2).asSequence()
                    .takeWhile { s[(center - it) / 2] == s[(center + it) / 2 - 1] }.lastOrNull() ?: 0
            else
                (1..min(center, lastPosition - center) step 2).asSequence()
                    .takeWhile { s[(center - it) / 2] == s[(center + it) / 2 - 1] }.last()
        }.maxBy(Pair<Int, Int>::second)!!
        return s.substring((center - length) / 2, (center + length) / 2)
    }
}