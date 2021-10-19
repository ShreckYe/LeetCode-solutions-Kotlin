import kotlin.math.min

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String =
        if (strs.isEmpty()) "" else strs.map { StringPrefixView(it) }.reduce { acc, s -> acc commonPrefixWith s }.toString()

    class StringPrefixView(val string: String, override val length: Int = string.length) : CharSequence {
        override fun get(index: Int): Char =
            if (index < length) string[index] else throw IndexOutOfBoundsException(index.toString())

        override fun subSequence(startIndex: Int, endIndex: Int): CharSequence =
            throw NotImplementedError()

        infix fun commonPrefixWith(other: StringPrefixView): StringPrefixView {
            val minLength = min(length, other.length)
            return StringPrefixView(string, (0 until minLength).firstOrNull { this[it] != other[it] } ?: minLength)
        }

        override fun toString(): String =
            string.substring(0, length)
    }
}