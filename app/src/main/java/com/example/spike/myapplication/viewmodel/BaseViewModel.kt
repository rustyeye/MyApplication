package com.example.spike.myapplication.viewmodel

import android.arch.lifecycle.ViewModel

//interface BaseViewModel {
//    fun onCreate()
//    fun onStart()
//    fun onResume()
//    fun onPause()
//    fun onStop()
//    fun onDestroy()
//
//
//    fun onAttach()
//    fun onCreate()
//    fun onCreateView()
//    fun onActivityCreated()
//    fun onStart()
//    fun onResume()
//    fun onPause()
//    fun onStop()
//    fun onDestroyView()
//    fun onDestroy()
//    fun onDetach()
//}

abstract class BaseViewModel : ViewModel() {
    override abstract fun onCleared()

    abstract fun onCreate()
    abstract fun onResume()
    abstract fun onPause()
    abstract fun onDestroy()
}

//open class BaseViewModel : ViewModel() {
//    override fun onCleared() {
//        super.onCleared()
//    }
//
//    open fun onCreate() {}
//    open fun onResume() {}
//    open fun onPause() {}
//    open fun onDestroy() {}
//}