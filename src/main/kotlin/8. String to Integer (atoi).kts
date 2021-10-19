import kotlin.test.assertEquals

@Suppress("NOTHING_TO_INLINE")
class Solution {
    fun myAtoi(str: String): Int {
        // true for positive, false for negative
        var sign: Boolean? = null
        var number: Long? = null
        for (c in str) {
            if (c == '+' || c == '-') {
                if (sign === null && number === null)
                    sign = c == '+'
                else
                    break
            } else if (c.isDigit()) {
                val digit = c - '0'
                if (number === null)
                    number = digit.toLong()
                else {
                    number = number * 10 + digit
                    if (sign === null || sign) {
                        if (number > Int.MAX_VALUE)
                            return Int.MAX_VALUE
                    } else
                        if (-number < Int.MIN_VALUE)
                            return Int.MIN_VALUE
                }
            } else if (c == ' ') {
                if (sign === null && number === null)
                    continue
                else
                    break
            } else
                break
        }

        return getNumber(number, sign)
    }

    inline fun getNumber(number: Long?, sign: Boolean?) =
        if (number !== null)
            if (sign === null || sign) number.toInt() else -number.toInt()
        else 0
}


// Tests
val solution = Solution()
assertEquals(42, solution.myAtoi("42"))
assertEquals(-42, solution.myAtoi("   -42"))
assertEquals(4193, solution.myAtoi("4193 with words"))
assertEquals(0, solution.myAtoi("words and 987"))
assertEquals(-2147483648, solution.myAtoi("-91283472332"))