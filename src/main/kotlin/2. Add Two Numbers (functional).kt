class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, carry: Int = 0): ListNode? =
        when {
            l1 === null -> addCarry(l2, carry)
            l2 === null -> addCarry(l1, carry)
            else -> {
                val (digit, nextCarry) = toDigitAndCarry(l1.`val` + l2.`val` + carry)
                ListNode(digit).apply {
                    next = addTwoNumbers(l1.next, l2.next, nextCarry)
                }
            }
        }

    fun addCarry(l: ListNode?, carry: Int): ListNode? =
        if (carry == 0)
            l
        else if (l === null)
            ListNode(carry)
        else {
            val (digit, nextCarry) = toDigitAndCarry(l.`val` + carry)
            ListNode(digit).apply {
                next = addCarry(l.next, nextCarry)
            }
        }

    fun toDigitAndCarry(sum: Int): Pair<Int, Int> =
        if (sum < 10) sum to 0 else sum - 10 to 1
}