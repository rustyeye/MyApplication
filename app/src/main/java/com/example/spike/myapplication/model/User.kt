package com.example.spike.myapplication.model

import android.databinding.ObservableField
import android.databinding.ObservableInt

class User {
    var name = ObservableField<String>()
    var age = ObservableInt()
    var imageUrl = ObservableField<String>()

    constructor(name : String, age : Int) {
        this.name.set(name)
        this.age.set(age)
        this.imageUrl.set("plus.png")
    }

    override fun toString(): String {
        return "${this.name.get()} ${this.age.get()}"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is User)
            return false
        return (this.name.get() == other.name.get() && this.age.get() == other.age.get())
    }

    override fun hashCode(): Int {
        return this.name.get()?.hashCode() ?: 0 + this.age.get()
    }
}