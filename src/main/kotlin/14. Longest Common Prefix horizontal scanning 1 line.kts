class Solution {
    fun longestCommonPrefix(strs: Array<String>): String =
        if (strs.isEmpty()) "" else strs.reduce { acc, s -> acc.commonPrefixWith(s) }
}