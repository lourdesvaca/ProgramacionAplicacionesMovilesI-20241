package com.example.practicodos.models

class Ingredient(var id: Int, var nombre: String, var imagenUrl: String) {
    override fun toString(): String {
        return nombre
    }
}