class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    @Suppress("NAME_SHADOWING")
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        var l1: ListNode? = l1
        var l2: ListNode? = l2

        val lHead = ListNode(0)
        var l = lHead
        var carry = 0
        do {
            var sum = (l1?.run(ListNode::`val`) ?: 0) + (l2?.run(ListNode::`val`) ?: 0) + carry
            if (sum < 10)
                carry = 0
            else {
                sum -= 10
                carry = 1
            }

            l.next = ListNode(sum)
            l = l.next!!

            l1 = l1?.next
            l2 = l2?.next
        } while (l1 !== null || l2 !== null || carry != 0)

        return lHead.next!!
    }
}