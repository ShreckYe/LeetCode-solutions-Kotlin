package shreckye.leetcode

import kotlin.test.assertEquals

for (permute in listOf(
    _46__Permutations_functional_programming.Solution()::permute,
    _46__Permutations_functional_programming_Streams.Solution()::permute,
    _46__Permutations_imperative_programming_linked_list.Solution()::permute,
    _46__Permutations_wrapped_Sequence_lists.Solution()::permute
)) {
    println(permute)
    System.out.flush()

    // Question exmaples
    assertEquals(
        listOf(listOf(1, 2, 3), listOf(1, 3, 2), listOf(2, 1, 3), listOf(2, 3, 1), listOf(3, 1, 2), listOf(3, 2, 1)),
        permute(intArrayOf(1, 2, 3))
    )
}