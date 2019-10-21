package com.alfansyah.android.kotlin_anko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.toast

class Register : AppCompatActivity(),AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        button_register_activity_register.setOnClickListener {
            val fullName = edit_text_full_name_activity_register.text.toString().trim()
            val username = edit_text_username_activity_register.text.toString().trim()
            val password = edit_text_password_activity_register.text.toString().trim()
            handleOnRegister(fullName = fullName, username = username, password = password)
        }
    }

    private fun handleOnRegister(fullName: String, username: String, password: String) {
        debug { "fullName: $fullName & username: $username & password: $password" }
        when {
            fullName.isEmpty() -> toast("Fullname is required.")
            username.isEmpty() -> toast("Username is required.")
            password.isEmpty() -> toast("Password is required.")
            else -> alert(title = "Register", message = "Your account has been created!") {
                positiveButton("OK") {
                    onBackPressed()
                }
            }.show()
        }
    }
}
