package com.example.aula16_exercicio2_conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.round

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConverter.setOnClickListener(this)
    }

    private fun converterCelsiusParaFahrenheit() {
        val grausFahrenheit = round(((edtTemperatura.text.toString().toDouble() * 9.0) / 5.0) + 32.0)

        txtMensagem.text = getString(R.string.mensagem, grausFahrenheit)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btnConverter -> converterCelsiusParaFahrenheit()
        }
    }

}