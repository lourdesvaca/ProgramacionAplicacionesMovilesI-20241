package com.example.practicadibujotablero.ui.model

import kotlin.random.Random

class Tablero {
    var filas = 8
    var columnas = 8

    // matriz llena de números del 1 al 6
    /*var matriz: Array<Array<Int>> = arrayOf(
        arrayOf(7, 2, 3, 4, 5, 6, 1, 2),
        arrayOf(2, 3, 4, 5, 6, 1, 2, 3),
        arrayOf(3, 4, 5, 6, 1, 2, 3, 4),
        arrayOf(4, 5, 2, 1, 2, 3, 4, 5),
        arrayOf(5, 6, 1, 2, 3, 4, 5, 6),
        arrayOf(6, 3, 2, 3, 4, 5, 6, 1),
        arrayOf(1, 2, 3, 4, 5, 6, 1, 2),
        arrayOf(2, 3, 4, 5, 7, 1, 2, 3)
    )*/

    //matriz llena de números aleatorias del 1-7
    var matriz: Array<Array<Int>> = Array(filas) {
        Array(columnas) {
            Random.nextInt(1, 7) // Genera un número aleatorio entre 1 y 7
        }
    }

    fun intercambiarCeldas(fila1: Int, columna1: Int, fila2: Int, columna2: Int) {
        val temp = matriz[fila1][columna1]
        matriz[fila1][columna1] = matriz[fila2][columna2]
        matriz[fila2][columna2] = temp
    }

}