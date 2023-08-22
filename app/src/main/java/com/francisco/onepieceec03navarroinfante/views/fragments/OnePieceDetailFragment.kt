package com.francisco.onepieceec03navarroinfante.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.francisco.onepieceec03navarroinfante.R

import com.francisco.onepieceec03navarroinfante.databinding.FragmentOnePieceDetailBinding
import com.francisco.onepieceec03navarroinfante.model.OnePiece


class OnePieceDetailFragment : Fragment() {
    private lateinit var binding: FragmentOnePieceDetailBinding
    val args: OnePieceDetailFragmentArgs by navArgs()
    private lateinit var onepiece: OnePiece
    private lateinit var viewModel: OnePieceDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onepiece = args.onepiece
        viewModel = ViewModelProvider (requireActivity()).get(OnePieceDetailViewModel:: class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnePieceDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgOnepiece.setImageResource(R.drawable.ic_arco1)
        binding.txtNameArco.text = onepiece.arctitle
        binding.txtDescripcion.text = onepiece.arcdescription
        binding.btnAddFavorite.apply {
            visibility = if (onepiece.isFavorite) View.GONE else View.VISIBLE
        }
        binding.btnAddFavorite.setOnClickListener{
            onepiece.isFavorite = true
            viewModel.addFavorite(onepiece)
            Toast.makeText(requireContext(),"Agreado a favoritos", Toast.LENGTH_SHORT).show()
        }
        binding.btnRemoveFavorite.apply {
            visibility = if (onepiece.isFavorite) View.VISIBLE else View.GONE
        }
        binding.btnRemoveFavorite.setOnClickListener{
            onepiece.isFavorite = true
            viewModel.removeFavorite(onepiece)
            Toast.makeText(requireContext(),"Favorito removido", Toast.LENGTH_SHORT).show()
        }

    }
}