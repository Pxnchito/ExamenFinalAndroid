package com.francisco.onepieceec03navarroinfante

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.francisco.onepieceec03navarroinfante.databinding.ItemOnepieceBinding
import com.francisco.onepieceec03navarroinfante.model.OnePIeceFirebase

class RVOnePieceListAdapterFirebase(var onepieces: List<OnePIeceFirebase>, private val onClick: (OnePIeceFirebase) -> Unit) : RecyclerView.Adapter<RVOnePieceListAdapterFirebase.OnePieceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnePieceViewHolder {
        val binding = ItemOnepieceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnePieceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnePieceViewHolder, position: Int) {
        holder.bind(onepieces[position])
    }

    override fun getItemCount(): Int = onepieces.size

    inner class OnePieceViewHolder(private val binding: ItemOnepieceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(onepiece: OnePIeceFirebase) {
            Glide
                    .with(binding.root.context)
                     .load(onepiece.img)
                     .into(binding.imageArco)

            binding.txtNameArco.text= onepiece.arctitte
            binding.txtDescripcion.text = onepiece.arcdescription

            binding.root.setOnClickListener { onClick(onepiece) }
        }
    }

    fun updateData(newClothes: List<OnePIeceFirebase>) {
        onepieces = newClothes
        notifyDataSetChanged()
    }

}