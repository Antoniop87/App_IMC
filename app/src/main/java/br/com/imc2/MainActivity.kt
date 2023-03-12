package br.com.imc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import br.com.imc2.databinding.ActivityMainBinding

private lateinit var result: TextView
 val altura = 0
 val peso = 0

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        result = binding.resultado
        configurabtn()
    }

    private fun configurabtn(){

        val btncalcular = binding.button
        btncalcular.setOnClickListener {
            validainput()
        }
    }

    private fun configuraresult(){
        val inputaltura = binding.alturainput.text.toString()
        val inputpeso = binding.pesoinput.text.toString()

        if (inputaltura.isEmpty() && inputpeso.isEmpty())
            return
        result.visibility = View.VISIBLE
    }

    private fun validainput() {
        val inputaltura = binding.alturainput.text.toString()
        val inputpeso = binding.pesoinput.text.toString()

        configuraresult()

        if (inputaltura.isEmpty() && inputpeso.isNotEmpty()){
            result.text = "Preencha o campos Altura"
        } else if (inputaltura.isNotEmpty() && inputpeso.isEmpty()){
            result.text = "Preencha o campo Peso"
        } else if (inputaltura.isEmpty() && inputpeso.isEmpty()){
            result.text = "Preencha os campos"
        }else {
            calcula()
        }
    }

    private fun calcula() {
        val inputaltura= binding.alturainput.text.toString()
        val inputpeso = binding.pesoinput.text.toString()

       // if (inputaltura.isEmpty() && inputpeso.isEmpty())
       //     return
       //     result.visibility = View.VISIBLE


         val calculo = inputpeso.toFloat()/(inputaltura.toFloat()*2)

        if (inputaltura == altura.toString() && inputpeso == peso.toString()){
            Toast.makeText(this, "preencha todos os campos", Toast.LENGTH_SHORT).show()
        } else if (calculo >= 18.5 && calculo <= 24.9){
            result.text = "Seu Imc é ${calculo} \n Você está no peso ideal"
        }else if (calculo <= 18.5){
            result.text = "Seu Imc é ${calculo} \n Você está abaixo do peso"
        } else if (calculo >= 25.0 && calculo <= 29.9){
            result.text = "Seu Imc é ${calculo} \n Você está com sobrepeso"
        } else if (calculo >= 30.0 && calculo < 40.0){
            result.text = "Seu Imc é ${calculo} \n Você está Obeso"
        } else {
            result.text = "Seu Imc é ${calculo} \n Você Com obesidade grave"
            //Toast.makeText(this, "preencha todos os campos", Toast.LENGTH_SHORT).show()
        }

    }
}