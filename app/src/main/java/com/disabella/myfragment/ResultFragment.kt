package com.disabella.myfragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class ResultFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_result, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = activity?.getSharedPreferences("main", Context.MODE_PRIVATE)


        if (sharedPref != null) {
            view.findViewById<TextView>(R.id.textViewLogin).text =
                sharedPref.getString("login", "Your login")

            view.findViewById<TextView>(R.id.textViewPassword).text =
                sharedPref.getString("password", "Your password")
        }
    }

}
