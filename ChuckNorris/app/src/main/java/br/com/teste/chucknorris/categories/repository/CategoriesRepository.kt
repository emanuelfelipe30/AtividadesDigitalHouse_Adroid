package br.com.teste.chucknorris.categories.repository

class CategoriesRepository {

    private val client = CategoriesEndpoint.endpoint

    suspend fun getCategories() = client.getCategories()

}