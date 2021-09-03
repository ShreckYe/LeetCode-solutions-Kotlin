import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.math.abs

class Solution {
    fun daysBetweenDates(date1: String, date2: String): Int =
        abs(ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)).toInt())
}