package com.example.cuadrado

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import model.Cuadrado


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Indentificacion de la cista
        val cuadradoView : ImageView = findViewById<ImageView>(R.id.cuadrado)

        /*usamos metodo post para que se ejecute este bloque de cogido en el hilo de la interfaz de usuario justo después de que se cargue
        la vista se construya y se mida
        */

        cuadradoView.post{
            //Varaibles que recogen los datos de la vista inicial
            val inicialAncho = cuadradoView.width
            val inicialAlto = cuadradoView.height
            val inicialX : Int = cuadradoView.x.toInt()
            val inicialY : Int =  cuadradoView.y.toInt()

            //Asociar la vista con el objeto cuadrado
            val cuadrado = Cuadrado(inicialAncho, inicialAlto).apply{
                x = inicialX
                y = inicialY
            }

            var buttonArriba : Button = findViewById<Button>(R.id.buttonArriba)
            var buttonAbajo : Button = findViewById<Button>(R.id.buttonAbajo)
            var buttonDerecha : Button = findViewById<Button>(R.id.buttonDerecha)
            var buttonIzquierda : Button = findViewById<Button>(R.id.buttonIzquierda)
            var buttonAumentarTamanio : Button = findViewById<Button>(R.id.buttonAumentarTamanio)
            var buttonDisminuirtamanio : Button = findViewById<Button>(R.id.buttonDisminuirTamanio)

            //Ponemos botones a la escucha
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
                //cuadrado.cambiarTamanio(150,150)

                // 1. Obtenemos el tamaño actual desde el objeto 'cuadrado'
                val anchoActual = cuadrado.ancho
                val altoActual = cuadrado.alto

                // 2. Calculamos el nuevo tamaño sumando el incremento
                val nuevoAncho = anchoActual + 10
                val nuevoAlto = altoActual + 10

                // 3. Establecemos el nuevo tamaño
                cuadrado.cambiarTamanio(nuevoAncho, nuevoAlto)

                actualizarVista(cuadrado, cuadradoView)
            }

            buttonDisminuirtamanio.setOnClickListener {
                //cuadrado.cambiarTamanio(150,150)

                // 1. Obtenemos el tamaño actual desde el objeto 'cuadrado'
                val anchoActual = cuadrado.ancho
                val altoActual = cuadrado.alto

                // 2. Calculamos el nuevo tamaño sumando el incremento
                val nuevoAncho = anchoActual - 10
                val nuevoAlto = altoActual - 10

                // 3. Establecemos el nuevo tamaño
                cuadrado.cambiarTamanio(nuevoAncho, nuevoAlto)

                actualizarVista(cuadrado, cuadradoView)
            }
        } //post
    }

    private fun actualizarVista (cuadrado:Cuadrado, cuadradoView:View){

        //Aqui es donde enlazamos la vista con el objeto
        //La vista actulizara su ancho y su alto con los datos del objeto
        cuadradoView.layoutParams.width = cuadrado.ancho
        cuadradoView.layoutParams.height = cuadrado.alto

        //Actulizamos las coordenadas
        cuadradoView.x = cuadrado.x.toFloat()
        cuadradoView.y = cuadrado.y.toFloat()

        //Ejecutar los cambios
        cuadradoView.requestLayout()
    }
}

