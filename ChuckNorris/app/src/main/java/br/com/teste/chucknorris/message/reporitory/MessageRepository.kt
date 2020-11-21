package br.com.teste.chucknorris.message.reporitory

class MessageRepository {

    private val client = MessageEndpoint.endpoint

    suspend fun getMessageByCategoryName(categoryName: String) = client.getMessageByCategoryName(categoryName)

}