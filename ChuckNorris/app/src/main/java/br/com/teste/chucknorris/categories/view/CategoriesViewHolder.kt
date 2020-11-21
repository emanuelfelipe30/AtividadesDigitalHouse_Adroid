package br.com.teste.chucknorris.categories.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.teste.chucknorris.R

class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val txtCategoryName = view.findViewById<TextView>(R.id.txtCategoryName)

    fun bind(categoryName: String) {
        txtCategoryName.text = categoryName
    }

}