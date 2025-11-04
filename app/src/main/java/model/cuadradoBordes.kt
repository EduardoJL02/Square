package model

import android.graphics.Color

/**
 * Clase nueva que hereda de cuadrado para practicar la herencia
 */
class CuadradoBordes(color: Int, ancho: Int, alto: Int, var borderColor: Int = Color.BLACK) : Cuadrado(color, ancho, alto) {
    //Método nuevo cambiarColorBorde
    fun cambiarColorBorde(nuevoColorBorde: Int) {
        borderColor = nuevoColorBorde
    }
}