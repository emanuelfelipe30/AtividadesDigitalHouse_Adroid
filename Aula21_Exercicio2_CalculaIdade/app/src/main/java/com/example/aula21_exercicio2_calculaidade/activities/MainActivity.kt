package com.example.aula21_exercicio2_calculaidade.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.aula21_exercicio2_calculaidade.fragments.CalcularIdadeFragment
import com.example.aula21_exercicio2_calculaidade.R
import com.example.aula21_exercicio2_calculaidade.fragments.ResultadoFragment
import com.example.aula21_exercicio2_calculaidade.interfaces.IEnviaNomeIdade

class MainActivity : AppCompatActivity(), IEnviaNomeIdade {

    private lateinit var manager: FragmentManager
    private val resultadoFragment = ResultadoFragment()
    private val calcularIdadeFragment = CalcularIdadeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = supportFragmentManager
        addFragment(R.id.frameCalculoIdade, calcularIdadeFragment)
        addFragment(R.id.frameResultado, resultadoFragment)
    }

    private fun addFragment(viewId: Int, fragment: Fragment){
        val transition = manager.beginTransaction()
        transition.replace(viewId, fragment)
        transition.commit()
    }

    override fun enviar(nome: String, idade: Int) {
        resultadoFragment.alterarMensagemNomeIdade(nome, idade)
    }
}
