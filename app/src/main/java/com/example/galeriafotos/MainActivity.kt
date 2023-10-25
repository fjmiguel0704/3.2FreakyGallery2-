package com.example.galeriafotos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.galeriafotos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val listaFotos = ArrayList<Imagen>()

    override fun onCreate(savedInstanceState: Bundle?) {
        val bindingActivity = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(bindingActivity.root)

        for (contador in 1..30){
            var foto = "https://loremflickr.com/320/240?look=$contador"
            listaFotos.add(Imagen(foto))
        }

        bindingActivity.vistaImagenes.adapter = ImagenAdapter(listaFotos, object : ImagenPulsada{
            override fun pulsarImagen(imagen: Imagen) {
                val intent = Intent(this@MainActivity, ImagenAmpliada::class.java)
                intent.putExtra("url", imagen.urlFoto)
                startActivity(intent)
            }
        })
    }
}