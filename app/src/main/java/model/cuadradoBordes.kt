package model

import android.graphics.Color

/**
 * Clase nueva que hereda de cuadrado para practicar la herencia
 */
class CuadradoBordes(color: Int, ancho: Int, alto: Int, var borderColor: Int = Color.BLACK) : Cuadrado(color, ancho, alto) {

    class ManejoColor{
        companion object{
            val RED = Color.RED
            val GREEN = Color.GREEN
            val BLUE = Color.BLUE
            val YELLOW = Color.YELLOW
            val CYAN = Color.CYAN
            val MAGENTA = Color.MAGENTA
            fun generarColorAleatorio() : Int {
                val colores = listOf(RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA)
                return colores.random()
            }
        }
    }
    //Método nuevo cambiarColorBorde
    fun cambiarColorBorde(nuevoColorBorde: Int) {
        borderColor = nuevoColorBorde
    }
}