package com.codigocode.webinar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var peso: EditText
    lateinit var altura:EditText
    lateinit var calcular:Button
    lateinit var viewFoto:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // mapeo los elementos
        peso = findViewById(R.id.peso)
        altura = findViewById(R.id.altura)
        calcular=findViewById(R.id.calcular)

        // definir el evento para el boton calcular

        calcular.setOnClickListener(View.OnClickListener {
            // podemos ponerle la funcionalidad para el boton

            // mostramos una tostada con un mensaje a modo de prueba

            Toast.makeText(this,"Peso: "+ peso.text + ", altura: "+ altura.text, Toast.LENGTH_LONG).show()
            // genero dos variables de tipo double , decimal
            val pesoDouble = peso.text.toString().toDouble()
            val alturaDouble = altura.text.toString().toDouble()

            val res = pesoDouble / (alturaDouble*alturaDouble)

            Toast.makeText(this,"resultado del IMC " +  res , Toast.LENGTH_LONG).show()

            viewFoto = findViewById(R.id.viewFoto)

            // genere un mapeo de mi layout y lo debo insertar en mi contendero llamado viewFoto
            val view = LayoutInflater.from(this).inflate(R.layout.foto_layout,null)
            val foto_resultado: ImageView = view.findViewById(R.id.fotoResultado)

            // previamente tenemos que darle el resultado

            // generar la logica del IMC

            if(res <= 18.4){
                // bajo peso
                foto_resultado.setImageResource(R.mipmap.flaco)

            }else if(res >= 18.5 && res <= 24.9){
                // peso nomrla
                foto_resultado.setImageResource(R.mipmap.normal)
            }else{
                // estamos en sobre peso
                foto_resultado.setImageResource(R.mipmap.gordo)
            }

            viewFoto.removeAllViews()
            viewFoto.addView(view)

        })
    }
}