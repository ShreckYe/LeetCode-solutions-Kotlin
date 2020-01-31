package shreckye.leetcode

class Solution {
    fun reverse(x: Int): Int {
        var q = x
        var y = 0L
        while (q != 0) {
            y = y * 10 + q % 10
            q /= 10
        }
        return if (y in Int.MIN_VALUE..Int.MAX_VALUE) y.toInt() else 0
    }
}