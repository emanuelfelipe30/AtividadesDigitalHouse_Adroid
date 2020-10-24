package com.digitalhouse.rickapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.Personagem
import com.squareup.picasso.Picasso

class CharacterRecyclerViewAdapter(private val dataSet: List<Personagem>): RecyclerView.Adapter<CharacterRecyclerViewAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val imgCharacterPicture by lazy {view.findViewById(R.id.imgCharacterPicture) as ImageView}
        private val txtCharacterName by lazy {view.findViewById(R.id.txtCharacterName) as TextView}
        private val txtCharacterGender by lazy {view.findViewById(R.id.txtCharacterGender) as TextView}
        private val txtCharacterPlanet by lazy {view.findViewById(R.id.txtCharacterPlanet) as TextView}

        @SuppressLint("SetTextI18n")
        fun bind(character: Personagem) {
            Picasso.get().load(character.imagemUrl).into(imgCharacterPicture)
            txtCharacterName.text = character.nome
            txtCharacterGender.text = "${character.status} - ${character.especie}"
            txtCharacterPlanet.text = character.localizacao.nome
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

}