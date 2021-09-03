package shreckye.leetcode

class Solution {
    fun reverse(x: Int): Int {
        @Suppress("NAME_SHADOWING") var x = x
        var y = 0L
        while (x != 0) {
            y = y * 10 + x % 10
            x /= 10
        }
        return if (y in Int.MIN_VALUE..Int.MAX_VALUE) y.toInt() else 0
    }
}