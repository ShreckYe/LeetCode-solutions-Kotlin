package shreckye.leetcode

// This solution causes StackOverflowError
@Suppress("NOTHING_TO_INLINE")
class Solution {
    fun isValid(s: String): Boolean =
        cancelBrackets(s, 0) == s.length

    companion object {
        const val CANCELLATION_FAILS = -1
    }

    // Cancels brackets and return the index of the first character after what's cancelled.
     fun cancelBrackets(s: String, startIndex: Int): Int {
        var index = startIndex
        while (true) {
            val newIndex = cancelSingleBracketGroup(s, index)
            if (newIndex == CANCELLATION_FAILS) break
            index = newIndex
        }
        return index
    }

     fun cancelSingleBracketGroup(s: String, startIndex: Int): Int {
        val firstChar = s.getOrElse(startIndex) { return CANCELLATION_FAILS }
        return doOnOpenOrClose(firstChar, {
            val innerEndIndex = cancelBrackets(s, startIndex + 1)
            when {
                match(firstChar, s.getOrElse(innerEndIndex) { return CANCELLATION_FAILS }) -> innerEndIndex + 1
                else -> CANCELLATION_FAILS
            }
        }, { CANCELLATION_FAILS })
    }

     inline fun <R> doOnOpenOrClose(char: Char, onOpen: () -> R, onClose: () -> R): R =
        when (char) {
            '(', '{', '[' -> onOpen()
            ')', '}', ']' -> onClose()
            else -> throw IllegalArgumentException("char=$char")
        }

     inline fun match(openChar: Char, closeChar: Char): Boolean =
        when (openChar) {
            '(' -> ')'
            '{' -> '}'
            '[' -> ']'
            else -> throw IllegalArgumentException("openChar=$openChar")
        } == closeChar
}