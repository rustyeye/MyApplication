package com.example.spike.myapplication

import android.net.Uri
import android.provider.MediaStore
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.newFixedThreadPoolContext
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_fun() {
        val a = listOf(1, 2, 3)
        val b = a.sum()
        println(b)

        val c = listOf(1, "2", "three")
        val d = c.sumBy {
            when (it) {
                is Number -> it.toInt()
                else -> 0
            }
        }
        println(d)

//        val Background = newFixedThreadPoolContext(2, "bg")
//        val job = launch(Background) {
//            val uri = Uri.withAppendedPath(imageBaseUri, imageId.toString())
//            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
//            launch(UI) {
//                imageView.SetImageBitmap(bitmap)
//            }
//        }
    }
}
