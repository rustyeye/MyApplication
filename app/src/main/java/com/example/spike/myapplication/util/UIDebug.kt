package com.example.spike.myapplication.util

import android.util.Log

fun <T : Any> T.ui_debug(tag: String, msg: String): T {
    Log.d(tag, msg)
    return this
}

fun <T : Any> T.ui_debug(msg: String): T {
    val className = this::class.java.simpleName
    val methodName = Throwable().stackTrace[1].methodName
    Log.d(className, "$methodName() $msg")
    //val lineNumber = Throwable().stackTrace[1].lineNumber
    //Log.d(className, "$methodName() $lineNumber $msg")
    return this
}
