package com.example.practicaapipersonas.models

typealias Libros = ArrayList<Libro>

data class Libro (
    val id: Int,
    val nombre: String,
    val isbn: String,
    val urlImagen: String,
    val sinopsis: String,
    val calificacion: Int
)