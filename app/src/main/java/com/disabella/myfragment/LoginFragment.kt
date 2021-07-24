package com.disabella.myfragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val login = view.findViewById<TextInputLayout>(R.id.loginLayout)
        val password = view.findViewById<TextInputLayout>(R.id.passwordLayout)
        //val sharedPref = getSharedPreferences("main", Context.MODE_PRIVATE)

        @SuppressLint("CommitPrefEdits")
        fun validate(): Int {
            var result = 0
            login.error = if (login.editText?.text.toString() != "admin") {
                "this Login is invalid"
            } else {
                //sharedPref.edit().putString("login", login.editText?.text.toString()).apply()
                result += 1
                null
            }
            password.error = if (password.editText?.text.toString() != "pass") {
                "this Password is invalid"
            } else {
                // sharedPref.edit().putString("password", password.editText?.text.toString()).apply()
                result += 1
                null
            }
            return result
        }

        password.editText?.setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    if (validate() == 2) {
                        parentFragmentManager.commit {
                            replace(R.id.container, ResultFragment()).addToBackStack(null)
                        }
                    }
                    true
                }
                else -> false
            }
        }
    }
}
