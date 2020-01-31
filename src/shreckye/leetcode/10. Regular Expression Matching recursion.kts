package shreckye.leetcode

@Suppress("NOTHING_TO_INLINE")
class Solution {
    fun isMatch(s: String, p: String): Boolean =
        isMatch(s, 0, p, 0)

    // Current version of Kotlin can't detect this type of tail calls.
    @Suppress("NO_TAIL_CALLS_FOUND", "NON_TAIL_RECURSIVE_CALL")
     tailrec fun isMatch(s: String, sIndex: Int, p: String, pIndex: Int): Boolean =
        when {
            pIndex == p.length -> sIndex == s.length
            p.getOrNull(pIndex + 1) == '*' -> isMatch(s, sIndex, p, pIndex + 2) ||
                    sIndex < s.length && isMatch(s[sIndex], p[pIndex]) && isMatch(s, sIndex + 1, p, pIndex)
            else -> sIndex < s.length && isMatch(s[sIndex], p[pIndex]) && isMatch(s, sIndex + 1, p, pIndex + 1)
        }

     inline fun isMatch(sChar: Char, pChar: Char): Boolean =
        pChar == '.' || sChar == pChar
}