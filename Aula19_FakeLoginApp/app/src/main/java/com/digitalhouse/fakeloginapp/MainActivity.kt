package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doLogin()
        navigateToCreateAccountScreen()
    }

    override fun onResume() {
        super.onResume()

        edtEmailLogin.setText("")
        edtPasswordLogin.setText("")

    }

    private fun doLogin() {

        btnLogin.setOnClickListener {
            val email = edtEmailLogin.text.toString().trim()
            val password = edtPasswordLogin.text.toString().trim()

            if(validateForm(email, password)) try{

                val user = UserService.logIn(email, password)

                if(user!= null){

                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("MY_NAME", user.name)
                    startActivity(intent)

                } else showMessage("Usuário ou senha incorreta")

            } catch(e: Exception) {
                showMessage(e.message!!)
            }
        }

    }

    private fun navigateToCreateAccountScreen() {
        btnNavigateToCreateAccountScreen.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateForm(email: String, password: String): Boolean {

        var isValidForm = true

        if(email.isEmpty()) {
            edtEmailLogin.error = "Preeencha o campo"
            isValidForm = false
        }

       if(password.isEmpty()) {
            edtPasswordLogin.error = "Preeencha o campo"
            isValidForm = false
        }

        return isValidForm

    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}