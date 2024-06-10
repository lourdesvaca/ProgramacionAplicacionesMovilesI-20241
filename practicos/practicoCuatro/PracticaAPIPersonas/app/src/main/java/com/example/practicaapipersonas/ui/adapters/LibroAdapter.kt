package com.example.practicaapipersonas.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaapipersonas.databinding.ProductItemLayoutBinding
import com.example.practicaapipersonas.models.Libro
import com.example.practicaapipersonas.models.Producto

class LibroAdapter : ListAdapter<Libro, LibroAdapter.LibroViewHolder>(LibroDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }

    class ProductViewHolder(private val binding: ProductItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Producto) {
            binding.lblProductName.text = product.nombre

        }
    }

    class ProductDiffCallback : DiffUtil.ItemCallback<Producto>() {
        override fun areItemsTheSame(oldItem: Producto, newItem: Producto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Producto, newItem: Producto): Boolean {
            return oldItem == newItem
        }
    }

    class LibroViewHolder {

    }
}

class LibroDiffCallback {

}
