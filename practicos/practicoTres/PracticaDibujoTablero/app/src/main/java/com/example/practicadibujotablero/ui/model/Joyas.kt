package com.example.practicadibujotablero.ui.model

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.AttributeSet
import android.view.View
import com.example.practicadibujotablero.R

class Joyas(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val tipo: Int
    val image: Bitmap
    val seleccionado: Boolean

    init {
        // Inicializar las imágenes de las joyas
        val blueImg = BitmapFactory.decodeResource(context?.resources, R.drawable.blue)
        val grayImg = BitmapFactory.decodeResource(context?.resources, R.drawable.gray)
        val greenImg = BitmapFactory.decodeResource(context?.resources, R.drawable.green)
        val orangeImg = BitmapFactory.decodeResource(context?.resources, R.drawable.orange)
        val purpleImg = BitmapFactory.decodeResource(context?.resources, R.drawable.purple)
        val redImg = BitmapFactory.decodeResource(context?.resources, R.drawable.red)
        val yellowImg = BitmapFactory.decodeResource(context?.resources, R.drawable.yellow)

        //Inicializas las imágenes de las joyas mágicas
        val blueMagicImg = BitmapFactory.decodeResource(context?.resources, R.drawable.bluemagic)
        val grayMagicImg = BitmapFactory.decodeResource(context?.resources, R.drawable.graymagic)
        val greenMagicImg = BitmapFactory.decodeResource(context?.resources, R.drawable.greenmagic)
        val orangeMagicImg = BitmapFactory.decodeResource(context?.resources, R.drawable.orangemagic)
        val purpleMagicImg = BitmapFactory.decodeResource(context?.resources, R.drawable.purplemagic)
        val redMagicImg = BitmapFactory.decodeResource(context?.resources, R.drawable.redmagic)
        val yellowMagicImg = BitmapFactory.decodeResource(context?.resources, R.drawable.yellowmagic)

        //Inicializar la imagen del cubo mágico para el 5 en línea
        val hipercubeImg = BitmapFactory.decodeResource(context?.resources, R.drawable.hipercube)


        // Asignar valores a las propiedades según el tipo de joya
        tipo = attrs?.getAttributeIntValue(null, "tipo", 0) ?: 0
        image = when (tipo) {
            1 -> blueImg
            2 -> grayImg
            3 -> greenImg
            4 -> orangeImg
            5 -> purpleImg
            6 -> redImg
            7-> yellowImg
            8 -> blueMagicImg
            9 -> grayMagicImg
            10 -> greenMagicImg
            11 -> orangeMagicImg
            12 ->  purpleMagicImg
            13 -> redMagicImg
            14 ->  yellowMagicImg
            else -> hipercubeImg
        }

        // Establecer la propiedad seleccionado como false por defecto
        seleccionado = false
    }
}