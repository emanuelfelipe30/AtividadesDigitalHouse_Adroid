package com.digitalhouse.rickapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.Personagem
import com.squareup.picasso.Picasso

class MeuAdapter(private val dataSet: List<Personagem>, private val listener: (Personagem) -> Unit): RecyclerView.Adapter<MeuAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val nome by lazy { view.findViewById(R.id.txtName) as TextView }
        private val imagem by lazy { view.findViewById(R.id.imgFoto) as ImageView }

        fun bind(personagem: Personagem){
            nome.text = personagem.nome
            Picasso.get()
                .load(personagem.imagemUrl)
                .into(imagem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_item, parent, false)

        return MeuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{listener(item)}
    }

    override fun getItemCount() = dataSet.size

}