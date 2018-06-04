package com.example.spike.myapplication.view

import android.databinding.DataBindingUtil
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.spike.myapplication.R

import com.example.spike.myapplication.databinding.ActivitySub1Binding
import com.example.spike.myapplication.model.User

class SubActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivitySub1Binding
    private var user : User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_sub1)

        val name = intent.getStringExtra("user.name")
        val age = intent.getIntExtra("user.age", 0)
        user = User(name, age)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub1)
        binding.setUser(user)
        binding.executePendingBindings()
    }

    fun onClicked1(view: View) {
        setResult(0)
        finish()
    }

    fun onClicked2(view: View) {
        setResult(2)
        finish()
    }
}
