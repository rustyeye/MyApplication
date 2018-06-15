package com.example.spike.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.FloatingActionButton
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.spike.myapplication.contract.MainContract

import com.example.spike.myapplication.databinding.ActivityMainBinding
import com.example.spike.myapplication.model.User
import com.example.spike.myapplication.util.replaceFragmentToActivity
import com.example.spike.myapplication.util.ui_debug
import com.example.spike.myapplication.view.RecyclerViewFragment
import com.example.spike.myapplication.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), MainContract {

    //private var user : User = User("MainActivity", 0)

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private val activityMainView by lazy {
        findViewById(R.id.activity_main_view) as ConstraintLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)

        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //binding.setUser(user)
        //binding.setVariable(BR.user, user)
        //binding.executePendingBindings()

        viewModel = MainViewModel(this as MainContract)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //binding.viewModel = viewModel
        binding.setViewModel(viewModel)

        viewModel.onCreate()
        binding.executePendingBindings()
    }

    override fun onResume() {
        super.onResume()

        viewModel.onResume()
    }

    override fun onPause() {
        super.onPause()

        viewModel.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()

        viewModel.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (resultCode) {
            0 -> Toast.makeText(this, "$requestCode", Toast.LENGTH_LONG).show()
        }
    }

    override fun onFabClicked(view: View) {
        ui_debug("")

        val fragment = RecyclerViewFragment()
        replaceFragmentToActivity(fragment, R.id.frame_layout)
    }

    override fun onAdd(item: User) {
        ui_debug("$item")
    }

    override fun onAdd(items: ArrayList<User>) {
        ui_debug("$items")
    }

    override fun onDelete(item: User?) {
        ui_debug("$item")
    }

    override fun onItemClicked(item: User) {
        ui_debug("$item")
    }

    override fun onShowError(error: String) {
        Snackbar.make(activityMainView, error, Snackbar.LENGTH_LONG).setAction("Action", null).show()
    }

    inline fun <reified T : Activity> Context.startActivity() {
        val intent = Intent(this, T::class.java)
        startActivity(intent)
    }

    inline fun <reified T : Activity> Context.startActivityForResult(requestCode: Int) {
        val intent = Intent(this, T::class.java)
        startActivityForResult(intent, requestCode)
    }

//    fun startNewActivity() {
//        val intent = Intent(this, NewActivity::class.java).apply {
//            putExtra("user.name", user.name.get())
//            putExtra("user.age", user.age.get())
//        }
//        startActivityForResult(intent, 1)
//    }

    fun <T : View> T.goneWhen(predicate: Boolean, block: T.() -> Unit) {
        if (predicate) {
            visibility = View.GONE
        }
        else {
            visibility = View.VISIBLE
            block()
        }
    }
}
