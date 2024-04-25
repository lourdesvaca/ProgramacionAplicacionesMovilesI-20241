package com.example.practicodos.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicodos.databinding.RecipeListItemBinding
import com.example.practicodos.models.Recipe

class RecipeAdapter : RecyclerView.Adapter<RecipeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(recipe: Recipe){
        /*RecipeListItemBinding.bind(itemView).apply {
            binding.apply {
                lblListRecipeTitle.setText(recipe.nombre)
                Glide.with(itemView.context).load(recipe.imagenUrl).into(imgListRecipeIcon)

            }
        }*/
    }
}
