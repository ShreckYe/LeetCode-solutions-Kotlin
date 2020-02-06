package shreckye.leetcode

class Solution {
    fun getPermutation(n: Int, k: Int): String =
        getPermutation((1..n).toIntNodeHead(), getIndices(n, k - 1).second)

    fun getIndices(n: Int, k: Int): Pair<IntNode> =
        // LeetCode doesn't compile [to]
        if (n == 1) Pair(k, IntNode(0))
        else {
            val (qk, indices) = getIndices(n - 1, k)
            Pair(qk / n, IntNode(qk % n, indices))
        }

    fun getPermutation(numsHead: IntNode, indiciesFirst: IntNode?): String =
        if (numsHead.next === null) ""
        else {
            val i = indiciesFirst!!.value
            var numsPrevNode: IntNode = numsHead
            repeat(i) { numsPrevNode = numsPrevNode.next!! }
            val numsNode = numsPrevNode.next!!
            numsPrevNode.next = numsNode.next

            ('0' + numsNode.value) + getPermutation(numsHead, indiciesFirst.next)
        }

    // For LeetCode
    data class Pair<out B>(val first: Int, val second: B) {
        override fun toString(): String = "($first, $second)"
    }

    // A simple singly linked list node implementation
    data class IntNode(val value: Int = 0, var next: IntNode? = null)

    @Suppress("NOTHING_TO_INLINE")
    inline fun IntRange.toIntNodeHead(): IntNode {
        val head = IntNode()
        var prevNode = head
        for (e in this) {
            val node = IntNode(e)
            prevNode.next = node
            prevNode = node
        }
        return head
    }
}