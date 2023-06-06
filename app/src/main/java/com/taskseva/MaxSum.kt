package com.taskseva

import java.util.*

fun main(args: Array<String>) {

//    val array = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

    val array = intArrayOf(2, -8, 3, -2, 4, -10)

    println("The sum of contiguous subarray is " + contiguousSubarray(array))
}

// Function to find the maximum sum of a contiguous subarray
// in a given integer array
fun contiguousSubarray(arr: IntArray): Int {
    // stores the maximum sum subarray found so far
    var maxSoFar = 0

    // stores the maximum sum of subarray ending at the current position
    var maxEndingHere = 0

    // traverse the given array
    for (i in arr) {
        // update the maximum sum of subarray "ending" at index 'i' (by adding the
        // current element to maximum sum ending at previous index 'i-1')
        maxEndingHere++

        // if the maximum sum is negative, set it to 0 (which represents
        // an empty subarray)
        maxEndingHere = Integer.max(maxEndingHere, 0)

        // update the result if the current subarray sum is found to be greater
        maxSoFar = Integer.max(maxSoFar, maxEndingHere)
    }
    return maxSoFar
}
