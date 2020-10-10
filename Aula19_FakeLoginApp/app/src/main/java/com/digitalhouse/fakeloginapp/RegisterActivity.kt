package com.digitalhouse.fakeloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_register.*
import java.lang.Exception

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setButtonEnabledDisabled()
        signUp()
        navigateToLoginScreen()

    }

    private fun setButtonEnabledDisabled() {
        checkAgreePrivacyPolicy.setOnCheckedChangeListener{ _, isChecked -> btnSignUp.isEnabled = isChecked }
    }

    private fun signUp() {

        btnSignUp.setOnClickListener{

            val name = edtNameSignUp.text.toString().trim()
            val email = edtEmailSignUp.text.toString().trim()
            val password = edtPasswordSignUp.text.toString().trim()

            if(validateForm(name, email, password)) try{

                UserService.register(name, email, password)
                showMessage("Usuário cadastrado com sucesso")
                finish()

            } catch(e: Exception) {
                showMessage(e.message!!)
            }

        }

    }

    private fun navigateToLoginScreen() {
        btnNavigateToLoginScreen.setOnClickListener{ finish() }
    }

    private fun validateForm(name: String, email: String, password: String): Boolean {

        var isValidForm = true

        if(name.isEmpty()) {
            edtNameSignUp.error = "Preeencha o campo"
            isValidForm = false
        }

        if(email.isEmpty()) {
            edtEmailSignUp.error = "Preeencha o campo"
            isValidForm = false
        }

        if(password.length < 8) {
            edtPasswordSignUp.error = "O campo deve ter no mínimo 8 caracteres"
            isValidForm = false
        }

        if(password.isEmpty()) {
            edtPasswordSignUp.error = "Preeencha o campo"
            isValidForm = false
        }

        return isValidForm

    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}