package com.francisco.onepieceec03navarroinfante

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.francisco.onepieceec03navarroinfante.databinding.ItemOnepieceBinding
import com.francisco.onepieceec03navarroinfante.model.OnePiece

class RVOnePieceListAdapter(var onepieces: List<OnePiece>): RecyclerView.Adapter<OnePieceVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnePieceVH {
        val binding = ItemOnepieceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnePieceVH(binding)
    }

    override fun getItemCount(): Int = onepieces.size

    override fun onBindViewHolder(holder: OnePieceVH, position: Int) {
        holder.bind(onepieces[position])
    }

}
class OnePieceVH(private val binding: ItemOnepieceBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(onePiece: OnePiece) {

        binding.imageArco.setImageResource(R.drawable.ic_arco1)
        binding.txtNameArco.text = onePiece.arc_title
        binding.txtDescripcion.text = onePiece.arc_description

    }
}