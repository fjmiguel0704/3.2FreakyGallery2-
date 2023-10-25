package com.example.galeriafotos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.galeriafotos.databinding.ItemImagenesBinding

class ImagenAdapter(private val lstaImagenes: ArrayList<Imagen>, private val pulsarImagen: ImagenPulsada): RecyclerView.Adapter<ImagenAdapter.ViewHolder>() {

    class ViewHolder(private val bindingItemImagen: ItemImagenesBinding):RecyclerView.ViewHolder(bindingItemImagen.root){
        fun bind(imagen: Imagen){
            Glide.with(bindingItemImagen.root.context).load(imagen.urlFoto).into(bindingItemImagen.ivImagen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bindingItemImagenes = ItemImagenesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bindingItemImagenes)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lstaImagenes[position])
        holder.itemView.setOnClickListener{
            pulsarImagen.pulsarImagen(lstaImagenes[position])
        }
    }

    override fun getItemCount(): Int {
        return lstaImagenes.size
    }
}