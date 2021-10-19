@Suppress("NOTHING_TO_INLINE")
class Solution {
    fun isMatch(s: String, p: String): Boolean =
        isMatch(Array(s.length + 1) { ByteArray(p.length) }, s, 0, p, 0)

    companion object {
        const val NULL: Byte = 0
        const val TRUE: Byte = 1
        const val FALSE: Byte = 2
        inline fun Byte.trueFalseToBoolean(): Boolean =
            when (this) {
                TRUE -> true
                FALSE -> false
                else -> throw IllegalArgumentException(toString())
            }

        inline fun Boolean.trueFalseToByte(): Byte =
            if (this) TRUE else FALSE
    }

    fun isMatch(isMatchDP: Array<ByteArray>, s: String, sIndex: Int, p: String, pIndex: Int): Boolean =
        if (pIndex == p.length) sIndex == s.length
        else {
            val isMatch = isMatchDP[sIndex][pIndex]
            if (isMatch != NULL)
                isMatch.trueFalseToBoolean()
            else
                (if (p.getOrNull(pIndex + 1) == '*')
                    isMatch(isMatchDP, s, sIndex, p, pIndex + 2) ||

                            sIndex < s.length && isMatch(s[sIndex], p[pIndex]) &&
                            isMatch(isMatchDP, s, sIndex + 1, p, pIndex)
                else
                    sIndex < s.length && isMatch(s[sIndex], p[pIndex]) &&
                            isMatch(isMatchDP, s, sIndex + 1, p, pIndex + 1))
                    .also { isMatchDP[sIndex][pIndex] = it.trueFalseToByte() }
        }

    inline fun isMatch(sChar: Char, pChar: Char): Boolean =
        pChar == '.' || sChar == pChar
}