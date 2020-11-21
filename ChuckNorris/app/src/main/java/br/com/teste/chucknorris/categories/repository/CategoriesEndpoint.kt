package br.com.teste.chucknorris.categories.repository

import br.com.teste.chucknorris.data.api.NetworkUtils
import retrofit2.http.GET

interface CategoriesEndpoint {

    @GET("categories")
    suspend fun getCategories(): List<String>

    companion object {
        val endpoint: CategoriesEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(CategoriesEndpoint::class.java)
        }
    }

}