package br.com.teste.chucknorris.message.model

import com.google.gson.annotations.SerializedName

data class MessageModel(
    @SerializedName("icon_url")
    val imageUrl: String,
    @SerializedName("value")
    val message: String
)