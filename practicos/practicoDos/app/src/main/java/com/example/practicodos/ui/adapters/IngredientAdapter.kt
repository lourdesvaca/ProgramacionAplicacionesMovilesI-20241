package com.example.practicodos.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practicodos.databinding.IngredienteListItemBinding
import com.example.practicodos.models.Ingredient


class IngredientAdapter(
    private val ingredients: ArrayList<Ingredient>
): RecyclerView.Adapter<IngredientViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        //realiza todo lo del binding, aqui se referencia al layout que corresponde
        val binding =
            IngredienteListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return IngredientViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        //retorna la cantidad de items de la lista
        return ingredients.size
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        //se encarga de asignar los valores correctos a cada item, nombre + foto
        val ingredient = ingredients[position]
        holder.bind(ingredient)
    }
}

class OnIngredientClickListener {

}

class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(ingredient: Ingredient) {
        IngredienteListItemBinding.bind(itemView).apply {
            lblIngredientName.setText(ingredient.nombre)
            Glide.with(itemView.context).load(ingredient.imagenUrl).into(imgIngredient)

            /*root.setOnClickListener {
                listener.onIngredientClick(ingredient)
            }
            view.setOnClickListener{
                listener.onIngredientClick(ingredient)
            }*/
        }
    }

}
