package shreckye.leetcode

import kotlin.test.assertEquals

for (longestCommonPrefix in listOf(
    _14__Longest_Common_Prefix_vertical_scanning.Solution()::longestCommonPrefix,
    _14__Longest_Common_Prefix_horizontal_scanning.Solution()::longestCommonPrefix,
    _14__Longest_Common_Prefix_horizontal_scanning_1_line.Solution()::longestCommonPrefix,
    _14__Longest_Common_Prefix_horizontal_scanning_Streams.Solution()::longestCommonPrefix,
    _14__Longest_Common_Prefix_horizontal_scanning_parallel_Streams.Solution()::longestCommonPrefix
)) {
    println(longestCommonPrefix)
    System.out.flush()

    // Question examples:
    assertEquals("fl", longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    assertEquals("", longestCommonPrefix(arrayOf("dog", "racecar", "car")))

    // Executed inputs:
    assertEquals("", longestCommonPrefix(arrayOf("")))
    assertEquals("a", longestCommonPrefix(arrayOf("acc", "aaaa", "aa")))
    assertEquals("", longestCommonPrefix(arrayOf()))
}