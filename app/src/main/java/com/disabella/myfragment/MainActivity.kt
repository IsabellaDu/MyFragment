package com.disabella.myfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment()

    }

    fun addFragment() {
        val splashFragment = SplashFragment()
        splashFragment.arguments = bundleOf(
            "some_int" to 123,
            "some_string" to "asdf",
            "some_more_string" to "qwerty",
            "some_boolean" to true
        )

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.container, splashFragment)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFragmentManager.popBackStack()
    }
}