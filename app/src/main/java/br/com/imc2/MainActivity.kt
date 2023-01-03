package br.com.imc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import br.com.imc2.databinding.ActivityMainBinding

private lateinit var result: TextView

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        result = binding.resultado
        var btncalcular = binding.button
        btncalcular.setOnClickListener {
            calcula()
        }
    }

    private fun calcula() {
        var inputaltura= binding.alturainput.text.toString()
        var inputpeso = binding.pesoinput.text.toString()

        if(inputaltura.isEmpty() && inputpeso.isEmpty())
            return
        result.visibility = View.VISIBLE

        val calculo = inputpeso.toFloat()/(inputaltura.toFloat()*2)

        if (calculo >= 18.5 && calculo <= 24.9){
            result.text = "Seu Imc é ${calculo} \n Você está no peso ideal"
        }else if (calculo <= 18.5){
            result.text = "Seu Imc é ${calculo} \n Você está abaixo do peso"
        } else if (calculo >= 25.0 && calculo <= 29.9){
            result.text = "Seu Imc é ${calculo} \n Você está com sobrepeso"
        } else if (calculo >= 30.0 && calculo < 40.0){
            result.text = "Seu Imc é ${calculo} \n Você está Obeso"
        } else {
            result.text = "Seu Imc é ${calculo} \n Você Com obesidade grave"
        }

    }
}