package com.taskseva

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.collections.HashMap

@RequiresApi(Build.VERSION_CODES.N)
fun main(args: Array<String>) {
    val keyboard = Scanner(System.`in`)
    println("Enter the world: ")
    val inputFromUser: String = keyboard.next()
    print(findLongestSubstring(inputFromUser))
}

@RequiresApi(Build.VERSION_CODES.N)
fun findLongestSubstring(str: String): String {

    var i: Int
    val n = str.length
    // Starting point
    // of current substring.
    var st = 0

    // length of
    // current substring.
    var currlen = 0

    // maximum length
    // substring without
    // repeating characters.
    var maxlen = 0

    // starting index of
    // maximum length substring.
    var start = 0

    // Hash Map to store last
    // occurrence of each

    // already visited character.
    val pos = HashMap<Char, Int>()

    // Last occurrence of first
    // character is index 0;
    pos[str[0]] = 0
    i = 1
    while (i < n) {

        // If this character is not present in hash,
        // then this is first occurrence of this
        // character, store this in hash.
        if (!pos.containsKey(str[i])) {
            pos[str[i]] = i
        } else {
            // If this character is present
            // in hash then this character
            // has previous occurrence,
            // check if that occurrence
            // is before or after starting
            // point of current substring.
            if (pos[str[i]]!! >= st) {
                // find length of current
                // substring and update maxlen
                // and start accordingly.
                currlen = i - st
                if (maxlen < currlen) {
                    maxlen = currlen
                    start = st
                }

                // Next substring will start
                // after the last occurrence
                // of current character to avoid
                // its repetition.
                st = pos[str[i]]!! + 1
            }

            // Update last occurrence of
            // current character.
            pos.replace(str[i], i)
        }
        i++
    }

    // Compare length of last
    // substring with maxlen and
    // update maxlen and start
    // accordingly.
    if (maxlen < i - st) {
        maxlen = i - st
        start = st
    }

    // The required longest
    // substring without
    // repeating characters
    // is from str[start]
    // to str[start+maxlen-1].
    return str.substring(
        start,
        start +
                maxlen
    )
}
