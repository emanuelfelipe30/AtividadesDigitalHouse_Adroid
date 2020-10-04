package com.example.aula16_exerciciocasa3_calculosalariohora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener(this)
    }

    private fun calcularSalario() {
        val salario = edtHorasTrabalhadas.text.toString().toInt() * edtValorHora.text.toString().toInt()

        txtMensagem.text = getString(R.string.mensagem, salario)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btnCalcular -> calcularSalario()
        }
    }

}