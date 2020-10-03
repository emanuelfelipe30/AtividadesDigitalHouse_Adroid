package com.example.aula16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*findViewById<TextView>(R.id.txtMeuTexto).text = "MEU APP"*/
        /*txtMeuTexto.text = "MEU APP!"*/

        /*btnLogin.setOnClickListener {
            txtMeuTexto.text = "MEU APP"
        }*/

        /*btnLogin.setOnClickListener(this)*/

        btnLogin.setOnClickListener {
            val emailDigitado = edtEmail.text.toString()
            val senhaDigitada = edtPassword.text.toString()

            txtMensagem.text = if(emailDigitado == EMAIL && senhaDigitada == SENHA) "Usuário logado com sucesso" else "E-mail ou senha incorreta"
            /*getString(R.string.minhastring)*/
        }

    }

    /*
    utilizar interface View.OnClickListener
    override fun onClick(v: View?) {
        TODO("Not yet implemented")
        when(v?.id) {
            R.id.btnLogin -> mudarTexto()
        }
    }

    fun mudarTexto() {
        txtMeuTexto.text = "MEU APP!"
    }*/
    companion object {
        const val EMAIL = "emanuelfelipe30@gmail.com"
        const val SENHA = "123456"
    }
}