import java.util.stream.IntStream
import java.util.stream.Stream
import kotlin.streams.asStream
import kotlin.streams.toList

class Solution {
    fun permute(nums: IntArray): List<List<Int>> =
        permuteStream(nums.asList()).map(IntStream::toList).toList()

    fun permuteStream(nums: List<Int>): Stream<IntStream> =
        if (nums.isEmpty()) Stream.of(IntStream.empty())
        else nums.asSequence().withIndex().asStream().flatMap { (i, num) ->
            permuteStream(nums.subList(0, i) + nums.subList(i + 1, nums.size))
                .map { IntStream.concat(IntStream.of(num), it) }
        }
}