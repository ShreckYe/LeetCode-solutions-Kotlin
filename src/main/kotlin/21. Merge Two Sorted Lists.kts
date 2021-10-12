class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? =
        when {
            l1 === null -> l2
            l2 === null -> l1
            else -> if (l1.`val` <= l2.`val`) l1.apply { next = mergeTwoLists(next, l2) }
            else l2.apply { next = mergeTwoLists(l1, next) }
        }
}
