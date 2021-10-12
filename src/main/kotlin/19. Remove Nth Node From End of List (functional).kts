class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? =
        helper(head, n).result

    data class HelperResult(val result: ListNode?, val distanceToNodeToRemove: Int?)

    fun helper(head: ListNode?, n: Int): HelperResult =
        if (head === null)
            HelperResult(head, n)
        else {
            val (nextResult, nextD) = helper(head.next, n)
            if (nextD === null)
                HelperResult(head.apply { next = nextResult }, null)
            else {
                val d = nextD - 1
                if (d == 0) HelperResult(nextResult, null)
                else HelperResult(head, d)
            }
        }
}