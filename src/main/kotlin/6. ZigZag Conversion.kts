import kotlin.test.assertEquals

@Suppress("NOTHING_TO_INLINE")
class Solution {
    companion object {
        inline infix fun Int.positiveCeilDiv(other: Int) =
            (this + other - 1) / other
    }

    fun convert(s: String, numRows: Int): String {
        if (numRows == 1)
            return s

        val length = s.length
        val numGroups = length positiveCeilDiv (numRows - 1)
        val lastRowIndex = numRows - 1
        val rows = Array(numRows) {
            StringBuilder(
                when (it) {
                    0 -> numGroups positiveCeilDiv 2
                    lastRowIndex -> numGroups / 2
                    else -> numGroups
                }
            )
        }

        // true for downward, false for upward
        var direction = true
        var rowNumber = 0
        for (c in s) {
            if (direction) {
                rows[rowNumber++].append(c)
                if (rowNumber == lastRowIndex)
                    direction = false
            } else {
                rows[rowNumber--].append(c)
                if (rowNumber == 0)
                    direction = true
            }
        }

        val convertedStringBuilder = StringBuilder(length)
        for (row in rows)
            convertedStringBuilder.append(row)

        return convertedStringBuilder.toString()
    }
}


// Tests
val solution = Solution()
assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3))
assertEquals("PINALSIGYAHRPI", solution.convert("PAYPALISHIRING", 4))