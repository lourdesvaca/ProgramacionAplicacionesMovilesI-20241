package com.example.practicodos.models

class Recipe(
    var id: Int,
    var nombre: String,
    var ingredientes: ArrayList<Ingredient>,
    var imagenUrl: String,
    var descripcion: String
) {
    override fun toString(): String {
        return nombre
    }
}