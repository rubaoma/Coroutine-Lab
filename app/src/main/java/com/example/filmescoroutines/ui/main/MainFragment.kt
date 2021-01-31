package com.example.filmescoroutines.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.filmescoroutines.R
import com.example.filmescoroutines.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    //View Binding
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = _binding!!.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            MainViewModel.MainViewModelFactory(MainRepository())
        ).get(MainViewModel::class.java)

        /**
         * Lista de filmes sendo retornada para o fragment
         * callback filmes ->
         */
        viewModel.filmesLiveData.observe(viewLifecycleOwner, Observer { filmes ->
            binding.textViewFilmes.text = filmes[0].titulo
        })

//        viewModel.getFilmes()
        viewModel.getFilmesCoroutine()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}