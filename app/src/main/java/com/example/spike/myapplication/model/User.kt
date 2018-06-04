package com.example.spike.myapplication.model

import android.databinding.ObservableField
import android.databinding.ObservableInt

class User (name : String, age : Int) {
    var name = ObservableField<String>()
    var age = ObservableInt()

    init {
        this.name.set(name)
        this.age.set(age)
    }
}