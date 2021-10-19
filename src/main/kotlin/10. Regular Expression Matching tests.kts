import kotlin.test.assertFalse

for (isMatch in listOf<(String, String) -> Boolean>(
    _10__Regular_Expression_Matching_recursion.Solution()::isMatch,
    _10__Regular_Expression_Matching_dynamic_programming.Solution()::isMatch
)) {
    println(isMatch)
    System.out.flush()

    // Question examples
    assertFalse(isMatch("aa", "a"))
    assert(isMatch("aa", "a*"))
    assert(isMatch("ab", ".*"))
    assert(isMatch("aab", "c*a*b"))
    assertFalse(isMatch("mississippi", "mis*is*p*."))
}