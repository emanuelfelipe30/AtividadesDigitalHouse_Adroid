package com.example.aula16_exerciciocasa1_meunome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnExibirNome.setOnClickListener(this)
    }

    private fun exibirNome() { txtNome.text = getString(R.string.mensagem, edtNome.text.toString()) }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btnExibirNome -> exibirNome()
        }
    }

}