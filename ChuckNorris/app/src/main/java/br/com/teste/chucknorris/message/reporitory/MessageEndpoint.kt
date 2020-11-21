package br.com.teste.chucknorris.message.reporitory

import br.com.teste.chucknorris.data.api.NetworkUtils
import br.com.teste.chucknorris.message.model.MessageModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MessageEndpoint {

    @GET("random")
    suspend fun getMessageByCategoryName(@Query("category") categoryName: String?): MessageModel

    companion object {
        val endpoint: MessageEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(MessageEndpoint::class.java)
        }
    }

}