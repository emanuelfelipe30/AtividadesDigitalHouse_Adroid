package br.com.teste.chucknorris.categories.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.teste.chucknorris.R
import br.com.teste.chucknorris.categories.repository.CategoriesRepository
import br.com.teste.chucknorris.categories.viewmodel.CategoriesViewModel

class CategoriesFragment : Fragment() {

    private lateinit var _view: View
    private lateinit var _recyclerCategories: RecyclerView
    private lateinit var _categoriesAdapter: CategoriesAdapter
    private lateinit var _viewModel: CategoriesViewModel

    private var _categories = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view

        _recyclerCategories = view.findViewById(R.id.recyclerCategories)
        val manager = LinearLayoutManager(view.context)

        _categoriesAdapter = CategoriesAdapter(_categories) {
            val action = CategoriesFragmentDirections.actionCategoriesFragmentToMessageFragment(it)
            findNavController().navigate(action)
        }

        _recyclerCategories.apply {

            setHasFixedSize(true)
            layoutManager = manager

            adapter = _categoriesAdapter
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager.VERTICAL
                )
            )

        }

        _viewModel = ViewModelProvider(
            this,
            CategoriesViewModel.CategoriesViewModelFactory(CategoriesRepository())
        ).get(CategoriesViewModel::class.java)

        _viewModel.getCategories().observe(viewLifecycleOwner, Observer{
            showResult(it)
        })

    }

    private fun showResult(categories: List<String>?) {

        categories?.let { _categories.addAll(it) }

        _categoriesAdapter.notifyDataSetChanged()
    }

}