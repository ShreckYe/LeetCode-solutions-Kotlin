import kotlin.test.assertEquals

class Solution {
    fun climbStairs(n: Int): Int =
        (FIBONACCI_MATRIX pow n).a22

    data class TwoTimesTwoSymmetricMatrix(val a11: Int, val a12AndA21: Int, val a22: Int) {
        // The product of two symmetric matrices is a symmetric matrix if and only if they commute.
        infix fun timesCommutatively(other: TwoTimesTwoSymmetricMatrix): TwoTimesTwoSymmetricMatrix =
            TwoTimesTwoSymmetricMatrix(
                a11 * other.a11 + a12AndA21 * other.a12AndA21,
                a11 * other.a12AndA21 + a12AndA21 * other.a22,
                a12AndA21 * other.a12AndA21 + a22 * other.a22
            )

        infix fun pow(exponent: Int): TwoTimesTwoSymmetricMatrix =
            if (exponent == 1) this
            else pow(exponent / 2).let { it timesCommutatively it }.let { if (exponent % 2 == 0) it else it timesCommutatively this }
    }

    companion object {
        val FIBONACCI_MATRIX = TwoTimesTwoSymmetricMatrix(0, 1, 1)
    }
}


// Tests
for (n in 1..10)
    assertEquals(
        generateSequence { Solution.FIBONACCI_MATRIX }.take(n).reduce(Solution.TwoTimesTwoSymmetricMatrix::timesCommutatively),
        Solution.FIBONACCI_MATRIX pow n
    )

val solution = Solution()
for (i in 1..10)
    println(solution.climbStairs(i))
assertEquals(1, solution.climbStairs(1))
assertEquals(2, solution.climbStairs(2))
assertEquals(3, solution.climbStairs(3))
assertEquals(5, solution.climbStairs(4))
assertEquals(8, solution.climbStairs(5))

