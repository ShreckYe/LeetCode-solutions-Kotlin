class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val minNums = IntArray(amount + 1) { -1 }
        minNums[0] = 0
        for (i in 1..amount)
            minNums[i] = coins.asSequence() // using `.asList()` is even slower
                .mapNotNull { coin -> minNums.getOrNull(i - coin)?.let { if (it != -1) it + 1 else null } }
                .minOrNull() ?: -1
        return minNums[amount]
    }
}