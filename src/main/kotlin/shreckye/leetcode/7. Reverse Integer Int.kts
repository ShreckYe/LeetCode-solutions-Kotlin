package shreckye.leetcode

@Suppress("NOTHING_TO_INLINE")
class Solution {
    companion object {
        inline infix fun Int.timesExact(other: Int): Int =
            Math.multiplyExact(this, other)

        inline infix fun Int.plusExact(other: Int): Int =
            Math.addExact(this, other)
    }

    fun reverse(x: Int): Int {
        var q = x
        var y = 0
        try {
            while (q != 0) {
                y = y timesExact 10 plusExact q % 10
                q /= 10
            }
        } catch (e: ArithmeticException) {
            return 0
        }
        return y
    }
}