package shreckye.leetcode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


@Suppress("NOTHING_TO_INLINE", "NAME_SHADOWING")
class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(0)
        var l1 = l1
        var l2 = l2
        var lPrev = head
        while (l1 !== null && l2 !== null) {
            val l: ListNode

            val v1 = l1.`val`
            val v2 = l2.`val`
            if (v1 < v2) {
                l = ListNode(v1)
                l1 = l1.next
            } else {
                l = ListNode(v2)
                l2 = l2.next
            }

            lPrev.next = l
            lPrev = l
        }

        // Should copy on more serious occasions
        lPrev.next = l1 ?: l2

        return head.next
    }
}