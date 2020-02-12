package shreckye.leetcode

class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        val lengthGcd = gcd(str1.length, str2.length)
        val gcdStr1 = str1.substring(0, lengthGcd)
        val gcdStr2 = str2.substring(0, lengthGcd)
        return if (gcdStr1 == gcdStr2 && gcdStr1.divides(str1, lengthGcd) && gcdStr2.divides(str2, lengthGcd)) gcdStr1
        else ""
    }

    tailrec fun gcd(a: Int, b: Int): Int =
        if (b == 0) a
        else gcd(b, a % b)

    fun String.divides(that: String, startIndex: Int): Boolean {
        var i = 0
        for (j in startIndex until that.length) {
            if (this[i] != that[j]) return false
            if (++i == this.length) i = 0
        }
        return i == 0
    }
}