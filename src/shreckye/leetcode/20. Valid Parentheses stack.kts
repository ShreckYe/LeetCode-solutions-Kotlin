package shreckye.leetcode

@Suppress("NOTHING_TO_INLINE")
class Solution {
    class SimpleCharStack(size: Int) {
        val stack = CharArray(size)
        var top = 0
        fun push(c: Char) {
            stack[top++] = c
        }

        inline fun peekOrElse(defaultValue: (Int) -> Char) =
            stack.getOrElse(top - 1, defaultValue)

        fun pop() =
            stack[--top]

        fun empty() =
            top == 0
    }

    fun isValid(s: String): Boolean {
        val stack = SimpleCharStack(s.length)

        for (char in s) {
            when (char) {
                '(', '{', '[' ->
                    stack.push(char)
                else -> {
                    val prevChar = stack.peekOrElse { return false }
                    if (match(prevChar, char))
                        stack.pop()
                    else
                        return false
                }
            }
        }
        return stack.empty()
    }

     inline fun match(openChar: Char, closeChar: Char): Boolean =
        when (openChar) {
            '(' -> ')'
            '{' -> '}'
            '[' -> ']'
            else -> throw IllegalArgumentException("openChar=$openChar")
        } == closeChar
}