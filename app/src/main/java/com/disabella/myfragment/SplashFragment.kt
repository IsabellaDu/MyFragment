package com.disabella.myfragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils.replace
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import java.time.temporal.TemporalAdjusters.next

class SplashFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = activity?.getSharedPreferences("main", Context.MODE_PRIVATE)

        if (sharedPref != null) {
            if (!sharedPref.contains("login") && !sharedPref.contains("password")) {

                Handler(Looper.getMainLooper()).postDelayed({
                    parentFragmentManager.commit {
                        replace(R.id.container, LoginFragment()).addToBackStack(null)
                    }
                }, 2000)
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    parentFragmentManager.commit {
                        replace(R.id.container, ResultFragment()).addToBackStack(null)
                    }
                }, 2000)

            }
        }
    }
}