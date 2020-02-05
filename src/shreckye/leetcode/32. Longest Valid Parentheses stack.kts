package shreckye.leetcode

import java.util.*

class Solution {
    fun longestValidParentheses(s: String): Int {
        val length = s.length
        // A stack of indices of left brackets
        val stack = IntArray(length)
        var top = 0
        val isInValidParentheses = BitSet(length)
        for ((i, c) in s.withIndex()) {
            when (c) {
                '(' -> stack[top++] = i
                ')' -> if (top > 0) {
                    isInValidParentheses.set(stack[--top])
                    isInValidParentheses.set(i)
                }
                else -> throw IllegalArgumentException("s[$i]=$c")
            }
        }

        // Count longest consecutive trues
        var numValidParentheses = 0
        var numLongestValidParentheses = 0
        for (i in 0 until length)
            if (isInValidParentheses[i])
                numValidParentheses++
            else {
                if (numValidParentheses > numLongestValidParentheses)
                    numLongestValidParentheses = numValidParentheses
                numValidParentheses = 0
            }
        if (numValidParentheses > numLongestValidParentheses)
            numLongestValidParentheses = numValidParentheses

        return numLongestValidParentheses
    }

    /*class SimpleIntStack(size: Int) {
        val stack = IntArray(size)
        var top = 0
        fun push(e: Int) {
            stack[top++] = e
        }

        fun pop() =
            stack[--top]

        fun empty() =
            top == 0
    }*/
}