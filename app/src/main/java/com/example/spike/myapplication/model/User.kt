package com.example.spike.myapplication.model

import android.databinding.ObservableField

class User (name : String, age : Int) {
    var name = ObservableField<String>()
    var age = ObservableField<Int>()

    init {
        this.name.set(name)
        this.age.set(age)
    }
}