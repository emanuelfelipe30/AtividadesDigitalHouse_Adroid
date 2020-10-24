package com.example.aula21_exercicio2_calculaidade.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aula21_exercicio2_calculaidade.interfaces.IEnviaNomeIdade
import com.example.aula21_exercicio2_calculaidade.R
import kotlinx.android.synthetic.main.fragment_calcular_idade.view.*
import java.util.*


class CalcularIdadeFragment : Fragment() {

    private lateinit var iEnviaNomeIdade: IEnviaNomeIdade

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_calcular_idade, container, false)

        view.btnCalcular.setOnClickListener {
            val nome = view.edtNome.editText?.text.toString()
            val anoNasc = view.edtAnoNasc.editText?.text.toString().toInt()
            val anoAtual = Calendar.getInstance().get(Calendar.YEAR)
            val idade = anoAtual - anoNasc

            iEnviaNomeIdade.enviar(nome, idade)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        iEnviaNomeIdade = context as IEnviaNomeIdade
    }

}