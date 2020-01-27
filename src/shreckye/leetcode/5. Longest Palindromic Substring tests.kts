package shreckye.leetcode

// Random tests
fun CharRange.randomString(length: Int) =
    String(CharArray(length) { random() })

val LOWERCASE_ALPHABETS = 'a'..'z'
val on2Solution = _5__Longest_Palindromic_Substring_O_n_2_.Solution()
val manacherSolution = _5__Longest_Palindromic_Substring_Manacher_s_algorithm.Solution()
repeat(1000) {
    println("Random test $it")
    val s = LOWERCASE_ALPHABETS.randomString(100)
    println("s = $s")
    val longestPalindrome = assertEqualsAndGet(on2Solution.longestPalindrome(s), manacherSolution.longestPalindrome(s))
    println("longestPalindrome.length = ${longestPalindrome.length}")
    println()
}