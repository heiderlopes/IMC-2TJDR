package com.example.logonpf.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.logonpf.imc.extension.format
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val peso = intent?.getStringExtra("PESO")!!.toDouble()
        val altura = intent?.getStringExtra("ALTURA")!!.toDouble()

        val imc = peso / (altura * altura)

        tvIMC.text = imc?.format(1)

        if(imc <= 18.5) {
            alterarTextoStatusIMC("Abaixo do peso")
            alterarImagemStatusIMC(R.drawable.abaixo)
        } else if (imc <= 24.9) {
            alterarTextoStatusIMC("Peso ideal")
            alterarImagemStatusIMC(R.drawable.ideal)
        }
    }

    fun alterarImagemStatusIMC(idImagem: Int) {
        ivStatusIMC.setImageDrawable(ContextCompat.getDrawable(this,
                idImagem))
    }

    fun alterarTextoStatusIMC(texto: String) {
        tvStatusIMC.text = texto
    }
}
