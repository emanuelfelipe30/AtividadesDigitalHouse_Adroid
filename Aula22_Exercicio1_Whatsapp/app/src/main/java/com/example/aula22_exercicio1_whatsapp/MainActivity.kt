package com.example.aula22_exercicio1_whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.minhaLista)
        val viewAdapter = MeuAdapter(
            arrayListOf(
                Conversa("Ana","Oi","14:29"),
                Conversa("João","Olá, boa tarde","13:32"),
                Conversa("Gabriela","Vlw","13:26"),
                Conversa("Luís","Top","13:23"),
                Conversa("Emanuel","Olá","13:12"),
                Conversa("Bia","Até amanhã","12:09"),
                Conversa("Duda","Top","12:07"),
                Conversa("Neto","Vlw","12:05"),
                Conversa("Lipe","Olá, boa tarde","12:04"),
                Conversa("Tércio","Oi","12:02"),
                Conversa("Dani","Top","11:45"),
                Conversa("Kelly","Até amanhã","11:43"),
                Conversa("Dédu","Vlw","11:32"),
                Conversa("Igor","Top","11:28"),
                Conversa("Islane","Vlw","11:13"),
                Conversa("Marília","Olá, boa tarde","10:34"),
                Conversa("Mariana","Até amanhã","10:23"),
                Conversa("Lucas","Top","10:21")
            )
        )

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = viewManager
            adapter = viewAdapter

            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}