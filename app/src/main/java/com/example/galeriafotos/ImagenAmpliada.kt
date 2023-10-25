package com.example.galeriafotos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.galeriafotos.databinding.ImagenAmpliadaBinding

class ImagenAmpliada : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val bindingImagenAmpliada = ImagenAmpliadaBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(bindingImagenAmpliada.root)

        val extras = intent.extras

        if (extras != null) {
            Glide.with(bindingImagenAmpliada.root.context).load(extras.getString("url")).into(bindingImagenAmpliada.imagenAmpliada)
        }

        bindingImagenAmpliada.imagenAmpliada.setOnClickListener{
            finish()
        }
    }
}