package br.com.teste.chucknorris.categories.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.teste.chucknorris.R

class CategoriesAdapter(
    private var categories: MutableList<String>,
    private val listener: (String) -> Unit
): RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_list_item, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val item = categories[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount() = categories.size
}