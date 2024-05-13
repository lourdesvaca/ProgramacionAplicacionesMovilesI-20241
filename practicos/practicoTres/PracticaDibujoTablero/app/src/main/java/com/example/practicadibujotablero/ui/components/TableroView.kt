package com.example.practicadibujotablero.ui.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.core.view.ancestors
import com.example.practicadibujotablero.R
import com.example.practicadibujotablero.ui.model.Tablero

class TableroView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var model: Tablero = Tablero()

    //creo las variables de las imágenes
    private var blueImg: Bitmap;
    private var grayImg: Bitmap;
    private var greenImg: Bitmap;
    private var orangeImg: Bitmap;
    private var purpleImg: Bitmap;
    private var redImg: Bitmap;
    private var yellowImg: Bitmap;

    private var blueMagicImg : Bitmap;
    private var grayMagicImg: Bitmap;
    private var greenMagicImg: Bitmap;
    private var orangeMagicImg : Bitmap;
    private var purpleMagicImg: Bitmap;
    private var redMagicImg : Bitmap;
    private var yellowMagicImg : Bitmap;
    private var hipercubeImg: Bitmap;

    private val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.FILL
    }

    //variables de origen|destino para el movimiento de las piezas
    private var agarrarColumna = -1;
    private var agarrarFila = -1;

    //inicializo img
    init {
        blueImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.blue);
        grayImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.gray);
        greenImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.green);
        orangeImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.orange);
        purpleImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.purple);
        redImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.red);
        yellowImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.yellow);
        blueMagicImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.bluemagic);
        grayMagicImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.graymagic);
        greenMagicImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.greenmagic);
        orangeMagicImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.orangemagic);
        purpleMagicImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.purplemagic);
        redMagicImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.redmagic);
        yellowMagicImg = BitmapFactory.decodeResource(context?.resources,
            R.drawable.yellowmagic);

        //Inicializar la imagen del cubo mágico para el 5 en línea
        hipercubeImg = BitmapFactory.decodeResource(context?.resources, R.drawable.hipercube)

        /*
        verifica desde el inicio
         */
        verificarMatch()
    }



    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val board = model
        val ancho = width / board.columnas
        val alto = height / board.filas
        for (i in 0 until board.filas) {
            for (j in 0 until board.columnas) {
                val bitmap = when (board.matriz[i][j]) {
                    1 -> blueImg
                    2 -> grayImg
                    3 -> greenImg
                    4 -> orangeImg
                    5 -> purpleImg
                    6 -> redImg
                    7 -> yellowImg
                    8 -> blueMagicImg
                    9 -> grayMagicImg
                    10 -> greenMagicImg
                    11 -> orangeMagicImg
                    12 ->  purpleMagicImg
                    13 -> redMagicImg
                    14 ->  yellowMagicImg
                    else -> hipercubeImg
                }
                bitmap?.let {
                    canvas.drawBitmap(
                        it,
                        (j * ancho).toFloat(),
                        (i * alto).toFloat(),
                        paint
                    )
                }
            }
        }
    }

    /*eventos touch, implementar solo "MotionEvent.ACTION_DOWN"
    * cada cuadrito tiene una dimensión de 50x50, el tablero es de 400x400
    * */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.action
        val touchX = event.x
        val touchY = event.y
        val cellWidth = width / model.columnas
        val cellHeight = height / model.filas

        when (action) {
            MotionEvent.ACTION_DOWN -> {
                agarrarFila = (touchY / cellHeight).toInt()
                agarrarColumna = (touchX / cellWidth).toInt()
            }
            MotionEvent.ACTION_MOVE -> {
                val newRow = (touchY / cellHeight).toInt()
                val newColumn = (touchX / cellWidth).toInt()
                if ((newRow != agarrarFila || newColumn != agarrarColumna) &&
                    ((newRow == agarrarFila && (newColumn == agarrarColumna + 1 || newColumn == agarrarColumna - 1)) ||
                            (newColumn == agarrarColumna && (newRow == agarrarFila + 1 || newRow == agarrarFila - 1)))
                ) {
                    model.intercambiarCeldas(agarrarFila, agarrarColumna, newRow, newColumn)
                    verificarMatch()
                    invalidate()
                    agarrarFila = newRow
                    agarrarColumna = newColumn

                }
            }
        }
        return true
    }


/*private fun verificarMatch() {
    verificarGrupo(3)
    verificarGrupo(4)
    verificarGrupo(5)
    verificarGrupo(6)
    verificarGrupo(7)
    verificarGrupo(8)

        for (longitud in 3..8) {
            verificarGrupo(longitud)
        }
    // Continúa hasta el límite de joyas en un grupo que desees verificar
}*/


    private fun verificarMatch() {
        for (longitud in 3..8) {
            verificarGrupo(longitud)
            verificarRayo()
        }

        llenarEspaciosVacios()
        invalidate()
    }

    private fun verificarGrupo(longitud: Int) {
        val filas = model.filas
        val columnas = model.columnas

        // Verificar grupos horizontales
        for (i in 0 until filas) {
            for (j in 0 until columnas - longitud + 1) {
                val figuraActual = model.matriz[i][j]
                var esGrupo = true
                // Aquí se comprueba si las siguientes longitud - 1 figuras son iguales a la figura actual
                for (k in 1 until longitud) {
                    if (model.matriz[i][j + k] != figuraActual) {
                        esGrupo = false
                        break
                    }
                }
                //si se hizo trica u otro, ingresa
                if (esGrupo) {
                    // Eliminar las joyas del grupo
                    for (k in 0 until longitud) {
                        model.matriz[i][j + k] = 0
                    }
                }
            }
        }

        // Verificar grupos verticales
        for (i in 0 until filas - longitud + 1) {
            for (j in 0 until columnas) {
                val figuraActual = model.matriz[i][j]
                var esGrupo = true
                for (k in 1 until longitud) {
                    if (model.matriz[i + k][j] != figuraActual) {
                        esGrupo = false
                        break
                    }
                }
                if (esGrupo) {
                    // Eliminar las joyas del grupo
                    for (k in 0 until longitud) {
                        model.matriz[i + k][j] = 0
                    }
                }
            }
        }
    }

    private fun llenarEspaciosVacios() {
        val filas = model.filas
        val columnas = model.columnas

        for (j in 0 until columnas) {
            for (i in filas - 1 downTo 0) {
                if (model.matriz[i][j] == 0) {
                    var k = i - 1
                    while (k >= 0 && model.matriz[k][j] == 0) {
                        k--
                    }
                    if (k >= 0) {
                        model.matriz[i][j] = model.matriz[k][j]
                        model.matriz[k][j] = 0
                    } else {
                        // Generar una nueva gema aleatoria
                        model.matriz[i][j] = (1..7).random()
                    }
                }
            }
        }
    }
     //si se forma la cruz se llama a esta función
    private fun verificarRayo(longitud: Int) {
        val filas = model.filas
        val columnas = model.columnas


        for (i in 0 until filas) {
            for (j in 0 until columnas - 2) {
                val figuraActual = model.matriz[i][j]
                val figuraSiguiente = model.matriz[i][j + 1]
                val figuraDespues = model.matriz[i][j + 2]
                val figuraAntes = if (j > 0) model.matriz[i][j - 1] else -1
                val figuraDespues2 = if (j < columnas - 3) model.matriz[i][j + 3] else -1

                if (figuraActual == figuraSiguiente &&
                    figuraActual == figuraDespues &&
                    figuraActual != figuraAntes &&
                    figuraActual != figuraDespues2) {

                    model.matriz[i][j] = 0
                    model.matriz[i][j + 1] = 0
                    model.matriz[i][j + 2] = 0

                }
            }
        }

        // Verificar rayo vertical
        for (i in 0 until filas - 2) {
            for (j in 0 until columnas) {
                val figuraActual = model.matriz[i][j]
                val figuraSiguiente = model.matriz[i + 1][j]
                val figuraDespues = model.matriz[i + 2][j]
                val figuraAntes = if (i > 0) model.matriz[i - 1][j] else -1
                val figuraDespues2 = if (i < filas - 3) model.matriz[i + 3][j] else -1

                if (figuraActual == figuraSiguiente &&
                    figuraActual == figuraDespues &&
                    figuraActual != figuraAntes &&
                    figuraActual != figuraDespues2) {
                    // Se encontró un rayo vertical, realizar las acciones necesarias
                    // Por ejemplo, eliminar las gemas del rayo
                    model.matriz[i][j] = 0
                    model.matriz[i + 1][j] = 0
                    model.matriz[i + 2][j] = 0

                }
            }
        }

        // repintar tablero
        invalidate()
    }


private fun verificarFuego(){

}

private fun verificarCubo(){

}
}