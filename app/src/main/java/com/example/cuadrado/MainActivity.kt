package com.example.cuadrado

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import model.Cuadrado
import model.CuadradoBordes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val cuadradoView : View = findViewById<View>(R.id.cuadrado)

        cuadradoView.post{
            val inicialAncho = cuadradoView.width
            val inicialAlto = cuadradoView.height
            val inicialX : Int = cuadradoView.x.toInt()
            val inicialY : Int =  cuadradoView.y.toInt()

            val cuadrado : CuadradoBordes = CuadradoBordes(ContextCompat.getColor(this, R.color.red), inicialAncho, inicialAlto)
                .apply{
                x = inicialX
                y = inicialY
                borderColor = ContextCompat.getColor(this@MainActivity, R.color.black)
            }

            val buttonArriba : Button = findViewById<Button>(R.id.buttonArriba)
            val buttonAbajo : Button = findViewById<Button>(R.id.buttonAbajo)
            val buttonDerecha : Button = findViewById<Button>(R.id.buttonDerecha)
            val buttonIzquierda : Button = findViewById<Button>(R.id.buttonIzquierda)
            val buttonAumentarTamanio : Button = findViewById<Button>(R.id.buttonAumentarTamanio)
            val buttonDisminuirtamanio : Button = findViewById<Button>(R.id.buttonDisminuirTamanio)
            val buttonCambiarColor : Button = findViewById<Button>(R.id.buttonCambiarColor)
            val buttonCambiarColorBorde : Button = findViewById<Button>(R.id.buttonCambiarColorBorde)

            buttonArriba.setOnClickListener{
                cuadrado.moverArriba()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonAbajo.setOnClickListener{
                cuadrado.moverAbajo()
                actualizarVista(cuadrado, cuadradoView)
            }

            buttonDerecha.setOnClickListener {
                cuadrado.moverDerecha()
                actualizarVista(cuadrado, cuadradoView)
            }

            buttonIzquierda.setOnClickListener{
                cuadrado.moverIzquierda()
                actualizarVista(cuadrado, cuadradoView)
            }

            buttonAumentarTamanio.setOnClickListener {
                val anchoActual = cuadrado.ancho
                val altoActual = cuadrado.alto
                val nuevoAncho = anchoActual + 10
                val nuevoAlto = altoActual + 10
                cuadrado.cambiarTamanio(nuevoAncho, nuevoAlto)
                actualizarVista(cuadrado, cuadradoView)
            }

            buttonDisminuirtamanio.setOnClickListener {
                val anchoActual = cuadrado.ancho
                val altoActual = cuadrado.alto
                val nuevoAncho = anchoActual - 10
                val nuevoAlto = altoActual - 10
                cuadrado.cambiarTamanio(nuevoAncho, nuevoAlto)
                actualizarVista(cuadrado, cuadradoView)
            }

            buttonCambiarColor.setOnClickListener{
                cuadrado.color = CuadradoBordes.ManejoColor.generarColorAleatorio()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonCambiarColorBorde.setOnClickListener{
                cuadrado.borderColor = CuadradoBordes.ManejoColor.generarColorAleatorio()
                actualizarVista(cuadrado, cuadradoView)
            }
        } //post
    }

    private fun actualizarVista (cuadrado: Cuadrado, cuadradoView:View){

        cuadradoView.layoutParams.width = cuadrado.ancho
        cuadradoView.layoutParams.height = cuadrado.alto

        if (cuadrado is CuadradoBordes) {
            val drawable = GradientDrawable()
            drawable.setColor(cuadrado.color)
            drawable.setStroke(10, cuadrado.borderColor)
            cuadradoView.background = drawable
        } else {
             cuadradoView.setBackgroundColor(cuadrado.color)
        }

        cuadradoView.x = cuadrado.x.toFloat()
        cuadradoView.y = cuadrado.y.toFloat()

        cuadradoView.requestLayout()
    }
}
