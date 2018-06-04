package com.example.spike.myapplication

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.example.spike.myapplication.databinding.ActivityMainBinding
import com.example.spike.myapplication.model.User
import com.example.spike.myapplication.view.SubActivity1
import com.example.spike.myapplication.view.SubActivity2

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var user : User = User("User0", 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //binding.setUser(user)
        binding.setVariable(BR.user, user)
        binding.executePendingBindings()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (resultCode) {
            0 -> Toast.makeText(this, "$requestCode", Toast.LENGTH_LONG).show()
            1 -> gotoSub1()
            2 -> gotoSub2()
        }
    }

    fun onTextViewClicked(view: View) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        if (user.name.get()!!.startsWith("Hello"))
            return

        user = User("Hello ${user.name.get()}!", 0)
        binding.setVariable(BR.user, user)
        //binding.setUser(user)
    }

    fun onClicked1(view: View) {
        gotoSub1()
    }

    fun onClicked2(view: View) {
        gotoSub2()
    }

    fun setUser(name: String, age: Int) {
        //user = User(name, age)
        //binding.setVariable(BR.user, user)
        //binding.setUser(user)

        user.name.set(name)
        user.age.set(age)
    }

    fun gotoSub1() {
        val intent = Intent(this, SubActivity1::class.java)
        intent.putExtra("user.name", user.name.get())
        intent.putExtra("user.age", user.age.get())
        startActivityForResult(intent, 1)
    }

    fun gotoSub2() {
        val intent = Intent(this, SubActivity2::class.java)
        intent.putExtra("user.name", user.name.get())
        intent.putExtra("user.age", user.age.get())
        startActivityForResult(intent, 2)
    }
}
