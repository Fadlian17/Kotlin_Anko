package com.alfansyah.android.kotlin_anko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(),AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_login_activity_main.setOnClickListener {
            val username = edit_text_username_activity_main.text.toString().trim()
            val password = edit_text_password_activity_main.text.toString().trim()
            handleOnLogin(username = username, password = password)
        }
        text_view_create_account_activity_main.setOnClickListener {
            // Intent to RegisterActivity class
            startActivity(intentFor<Register>())
            Toast.LENGTH_SHORT
        }
    }

    private fun handleOnLogin(username: String, password: String) {
        // Logging with Anko
        debug { "username: $username and password: $password" }

        if (username == "AnkoKotlin" && password == "kotlin123") {
            // Login success, show toast
            toast("Hi $username, You're logged in")
            // or long toast
            // longToast("Hi $username, You're logged in")
        } else {
            // Login failed, show alert dialog
            alert(title = getString(R.string.title_login_failed), message = getString(R.string.message_login_failed)) {
                positiveButton(buttonText = "OK") {
                    // TODO: do something in here if user tap button OK
                }
            }.show()
        }
    }
}
