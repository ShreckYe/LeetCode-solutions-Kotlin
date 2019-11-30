package shreckye.leetcode

import kotlin.test.assertEquals

fun <T> assertEqualsAndGet(expected: T, actual: T, message: String? = null): T {
    assertEquals(expected, actual, message)
    return actual
}