import kotlin.math.abs

class Solution {
    companion object {
        val NUM_MONTHS = 12
        val COMMON_YEAR_MONTH_DAYS = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        val COMMON_YEAR_MONTH_DAYS_ACC = IntArray(NUM_MONTHS + 1).also {
            it[0] = 0
            for (i in 0 until NUM_MONTHS)
                it[i + 1] = it[i] + COMMON_YEAR_MONTH_DAYS[i]
        }

        fun getMonthDaysAcc(month: Int, isLeapYear: Boolean) =
            COMMON_YEAR_MONTH_DAYS_ACC[month - 1].let { if (month > 2 && isLeapYear) it + 1 else it }
    }

    fun daysBetweenDates(date1: String, date2: String): Int {
        fun String.splitDate() = split('-').map(String::toInt)
        val (year1, month1, day1) = date1.splitDate()
        val (year2, month2, day2) = date2.splitDate()

        return abs(
            daysBetweenYears(year1, year2) +
                    daysBetweenMonths(month1, isLeapYear(year1), month2, isLeapYear(year2)) +
                    (day2 - day1)
        )
    }

    fun daysBetweenYears(year1: Int, year2: Int): Int =
        365 * (year2 - year1) + (countLeapYearsAcUntil(year2) - countLeapYearsAcUntil(year1))

    fun daysBetweenMonths(month1: Int, isMonth1InLeapYear: Boolean, month2: Int, isMonth2InLeapYear: Boolean) =
        getMonthDaysAcc(month2, isMonth2InLeapYear) - getMonthDaysAcc(month1, isMonth1InLeapYear)

    fun countLeapYearsAcUntil(year: Int): Int {
        val maxYear = year - 1
        return maxYear / 4 - maxYear / 100 + maxYear / 400
    }

    fun isLeapYear(year: Int): Boolean =
        year % 4 == 0 && year % 100 != 0 || year % 400 == 0
}