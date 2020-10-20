package com.example.aula22_exercicio1_whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MeuAdapter(private val dataSet: List<Conversa>): RecyclerView.Adapter<MeuAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val nome by lazy { view.findViewById(R.id.txtNome) as TextView }
        private val mensagem by lazy { view.findViewById(R.id.txtMensagem) as TextView }
        private val hora by lazy { view.findViewById(R.id.txtHora) as TextView }

        fun bind(conversa: Conversa){
            nome.text = conversa.nome
            mensagem.text = conversa.mensagem
            hora.text = conversa.hora
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)

        return MeuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

}