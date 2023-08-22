package com.francisco.onepieceec03navarroinfante.views.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.francisco.onepieceec03navarroinfante.RVOnePieceListAdapterFirebase
import com.francisco.onepieceec03navarroinfante.databinding.FragmentFirebaseBinding
import com.francisco.onepieceec03navarroinfante.views.AddOnePieceActivity
import java.util.zip.Inflater

class FirebaseFragment : Fragment() {
    private lateinit var binding: FragmentFirebaseBinding
    private lateinit var adapter: RVOnePieceListAdapterFirebase
    private lateinit var viewModel: FirebaseListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirebaseBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = RVOnePieceListAdapterFirebase(emptyList()){
        }
        viewModel= ViewModelProvider(this).get(FirebaseListViewModel::class.java)
        binding.rvOnepieceList.adapter=adapter
        binding.rvOnepieceList.layoutManager =
            GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
        viewModel.onepiece.observe(viewLifecycleOwner,Observer{onepiece->
            adapter.updateData(onepiece)
            adapter.notifyDataSetChanged()
        })
        viewModel.firebaseList()
        binding.fabAddOnepiece.setOnClickListener {
            val intent = Intent(requireContext(), AddOnePieceActivity::class.java)
            startActivity(intent)
        }
    }


}