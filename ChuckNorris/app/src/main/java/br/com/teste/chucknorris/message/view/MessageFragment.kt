package br.com.teste.chucknorris.message.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.teste.chucknorris.R
import br.com.teste.chucknorris.message.reporitory.MessageRepository
import br.com.teste.chucknorris.message.viewmodel.MessageViewModel
import com.squareup.picasso.Picasso

class MessageFragment : Fragment() {

    private lateinit var _viewModel: MessageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryName = requireArguments().let { MessageFragmentArgs.fromBundle(it).categoryName }

        _viewModel = ViewModelProvider(
            this,
            MessageViewModel.MessageViewModelFactory(MessageRepository())
        ).get(MessageViewModel::class.java)

        _viewModel.getMessageByCategoryName(categoryName).observe(viewLifecycleOwner, Observer{

            val imgChuck = view.findViewById<ImageView>(R.id.imgChuck)
            val txtMessageChuck = view.findViewById<TextView>(R.id.txtMessageChuck)

            if (it != null) {
                Picasso.get()
                    .load(it.imageUrl)
                    .into(imgChuck)
                txtMessageChuck.text = it.message
            }

        })
    }

}