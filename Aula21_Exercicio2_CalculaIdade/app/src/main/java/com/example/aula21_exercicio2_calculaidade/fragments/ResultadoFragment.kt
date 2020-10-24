package com.example.aula21_exercicio2_calculaidade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aula21_exercicio2_calculaidade.R
import kotlinx.android.synthetic.main.fragment_resultado.view.*

class ResultadoFragment : Fragment() {

    private lateinit var minhaView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        minhaView = inflater.inflate(R.layout.fragment_resultado, container, false)

        return minhaView
    }

    fun alterarMensagemNomeIdade(nome: String, idade: Int){
        minhaView.txtResultado.text = getString(R.string.result_mensagem, nome, idade)
        minhaView.txtResultado.visibility = View.VISIBLE
    }

}