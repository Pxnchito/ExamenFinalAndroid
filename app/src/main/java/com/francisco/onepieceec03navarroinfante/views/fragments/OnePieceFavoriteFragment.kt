package com.francisco.onepieceec03navarroinfante.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.francisco.onepieceec03navarroinfante.RVOnePieceListAdapter
import com.francisco.onepieceec03navarroinfante.databinding.FragmentOnePieceFavoriteBinding


class OnePieceFavoriteFragment : Fragment() {


    private lateinit var binding: FragmentOnePieceFavoriteBinding
    private lateinit var viewModel: OnePieceFavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(OnePieceFavoriteViewModel:: class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnePieceFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RVOnePieceListAdapter(listOf()){ onepiece->
            //navegar al detalle
            val OnePieceDetailDirection= OnePieceFavoriteFragmentDirections.actionOnePieceFavoriteFragmentToOnePieceDetailFragment(onepiece)
            findNavController().navigate(OnePieceDetailDirection)
        }
        binding.rvOnepieceList.adapter = adapter
        binding.rvOnepieceList.layoutManager = GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
        viewModel.favorites.observe(  requireActivity()) {
            adapter.onepieces = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getFavorites()

    }

}