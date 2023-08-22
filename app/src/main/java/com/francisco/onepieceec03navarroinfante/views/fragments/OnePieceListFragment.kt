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
import com.francisco.onepieceec03navarroinfante.databinding.FragmentOnePieceListBinding


class OnePieceListFragment : Fragment() {

    private lateinit var binding: FragmentOnePieceListBinding
    private lateinit var viewModel: OnePieceListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(OnePieceListViewModel:: class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnePieceListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVOnePieceListAdapter(listOf()){onepiece ->
                //navegar al detalle
                val OnePieceDetailDirection= OnePieceListFragmentDirections.actionOnePieceListFragmentToOnePieceDetailFragment(onepiece)
                findNavController().navigate(OnePieceDetailDirection)
        }
        binding.rvOnepieceList.adapter = adapter
        binding.rvOnepieceList.layoutManager = GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
        viewModel.onepieceList.observe(viewLifecycleOwner) {onepiece ->
                onepiece?.let {
                    adapter.onepieces= it
                    adapter.notifyDataSetChanged()
                }
        }
        viewModel.getOnePieceFromService()
    }
}