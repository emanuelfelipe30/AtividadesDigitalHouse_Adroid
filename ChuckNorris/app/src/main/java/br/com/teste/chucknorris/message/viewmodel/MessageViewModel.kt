package br.com.teste.chucknorris.message.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import br.com.teste.chucknorris.message.model.MessageModel
import br.com.teste.chucknorris.message.reporitory.MessageRepository
import kotlinx.coroutines.Dispatchers

@Suppress("UNCHECKED_CAST")
class MessageViewModel(
    private val repository: MessageRepository
): ViewModel() {

    var message: MessageModel? = null

    fun getMessageByCategoryName(categoryName: String) = liveData(Dispatchers.IO) {
        message = repository.getMessageByCategoryName(categoryName)
        emit(message)
    }

    class MessageViewModelFactory(
        private val repository: MessageRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MessageViewModel(repository) as T
        }
    }
}