package com.digitalhouse.rickapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.IRespostaDaApi
import com.digitalhouse.rickapp.api.Personagem
import com.digitalhouse.rickapp.api.RickApi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = GridLayoutManager(this, 2)

        RickApi.getData(this, object: IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {

                //var toast : Toast? = null

                val recyclerView = findViewById<RecyclerView>(R.id.minhaLista)
                val viewAdapter = MeuAdapter(personagens){ personagem ->
                    /*toast?.cancel()
                    toast = Toast.makeText(this@MainActivity, personagem.nome, Toast.LENGTH_LONG)
                    toast?.show()*/
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                    intent.putExtra("URL", personagem.imagemUrl)
                    intent.putExtra("NAME", personagem.nome)
                    intent.putExtra("SPECIES", personagem.especie)
                    intent.putExtra("GENDER", personagem.genero)
                    startActivity(intent)
                }

                recyclerView.apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter

                }

            }
        })
    }

}