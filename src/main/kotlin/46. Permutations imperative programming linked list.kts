// There is no Sequence overhead or list concatenation in this implementation, so it is much faster but can't be parallelized.
class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val size = nums.size
        val permutations = ArrayList<List<Int>>(factorial(size))
        addPermutations(permutations, ArrayList(size), nums.toIntNodeHead())
        //if (permutations.size != factorial(nums.size)) throw AssertionError()
        return permutations
    }

    fun factorial(n: Int): Int =
        if (n == 0) 1
        else n * factorial(n - 1)

    fun addPermutations(
        permutations: ArrayList<List<Int>>, orderedNumbers: ArrayList<Int>, unorderedNumbersHead: IntNode
    ) {
        if (unorderedNumbersHead.next === null)
            permutations.add(orderedNumbers.toIntArray().asList())
        else {
            var prevNode: IntNode = unorderedNumbersHead
            while (true) {
                val node = prevNode.next
                if (node === null)
                    break

                prevNode.next = node.next
                orderedNumbers.add(node.value)

                addPermutations(permutations, orderedNumbers, unorderedNumbersHead)

                orderedNumbers.removeAt(orderedNumbers.lastIndex)
                prevNode.next = node

                prevNode = node
            }
        }
    }

    // A simple singly linked list node implementation
    class IntNode(val value: Int = 0, var next: IntNode? = null)

    fun IntArray.toIntNodeHead(): IntNode {
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