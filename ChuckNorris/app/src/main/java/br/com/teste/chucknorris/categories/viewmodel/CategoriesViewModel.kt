package br.com.teste.chucknorris.categories.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import br.com.teste.chucknorris.categories.repository.CategoriesRepository
import kotlinx.coroutines.Dispatchers

@Suppress("UNCHECKED_CAST")
class CategoriesViewModel(private val repository: CategoriesRepository): ViewModel() {

    private var categories: List<String> = listOf()

    fun getCategories() = liveData(Dispatchers.IO) {
        categories = repository.getCategories()
        emit(categories)
    }

    class CategoriesViewModelFactory(
        private val repository: CategoriesRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CategoriesViewModel(repository) as T
        }
    }

}