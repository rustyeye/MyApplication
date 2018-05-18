package com.example.spike.myapplication

import android.databinding.DataBindingUtil
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.spike.myapplication.databinding.ActivityMainBinding
import com.example.spike.myapplication.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var user : User = User("신성환", 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //binding.setUser(user)
        binding.setVariable(BR.user, user)
        binding.executePendingBindings()

//        textview.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//            //textview.setText("Hello World!")
//            user = User("Hello World!", 0)
//        }
//
//        button1.setOnClickListener {
//            //textview.setText("Button1")
//            setUser("Button1", 1)
//        }
//
//        button2.setOnClickListener {
//            //textview.setText("Button2")
//            setUser("Button2", 2)
//        }
//
//        button3.setOnClickListener {
//            //textview.setText("Button3")
//            setUser("Button3", 3)
//        }
//
//        button4.setOnClickListener {
//            //textview.setText("Button4")
//            setUser("Button4", 4)
//        }
    }

    fun onTextViewClicked(view: View) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        user = User("Hello World!", 0)
        //binding.setUser(user)
        binding.setVariable(BR.user, user)
    }

    fun onClicked1(view: View) {
        setUser("Button1", 1)
    }

    fun onClicked2(view: View) {
        setUser("Button2", 1)
    }

    fun onClicked3(view: View) {
        setUser("Button3", 1)
    }

    fun onClicked4(view: View) {
        setUser("Button4", 1)
    }

    fun setUser(name: String, age: Int) {
        user.name.set(name)
        user.age.set(age)
    }
}
