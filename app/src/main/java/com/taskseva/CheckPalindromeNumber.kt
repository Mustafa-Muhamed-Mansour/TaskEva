package com.taskseva

import java.util.*

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)
    println("Enter the number: ")
    val inputFromUser: Int = scanner.nextInt()

    if (isPalindrome(inputFromUser)) {
        println("true")
    } else {
        println("false")
    }

}

     fun isPalindrome(num: Int): Boolean {
    // `n` stores the given integer
    var n = num

    // `rev` stores the reverse of the given integer
    var rev = 0
    while (n > 0) {
        // this will store the last digit of `n` in variable `r`
        // e.g. if `n` is 1234, then `r` would be 4
        val r = n % 10

        // add `r` to `rev` in one's place
        // e.g. if `rev = 65` and `r = 4`, then new `rev` would be 654
        rev = rev * 10 + r

        // remove the last digit from `n`
        // e.g. if `n` is 1234, then the new `n` would be 123
        n = n / 10
    }

    // this expression will return 1 if the given number is equal to
    // its reverse; otherwise, it will return 0
    return num == rev
}