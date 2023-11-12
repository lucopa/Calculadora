package com.example.calculadora

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var oper: Int = 0
    var numero1: Double = 0.0
    lateinit var contador1: TextView
    lateinit var contador2: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIgual: Button = findViewById(R.id.btnIgual)
        val btnBorrar: Button = findViewById(R.id.btnBorrar)
        contador1 = findViewById(R.id.contador1)
        contador2 = findViewById(R.id.contador2)

        btnIgual.setOnClickListener{
            var num2 = contador2.text.toString().toDouble()
            var res = 0.0
            when(oper){
                1-> res = numero1 + num2
                2-> res = numero1- num2
                3-> res = numero1 * num2
                4-> res = numero1 / num2
            }
            contador2.setText(res.toString())
            contador1.setText("")
        }

        btnBorrar.setOnClickListener{
            contador1.setText("")
            contador2.setText("")
            oper = 0
        }

    }

    fun clicNumero(view: View){
        var num2 = contador2.text.toString()

        when(view.id){
            R.id.btn0 -> contador2.setText(num2+"0")
            R.id.btn1 -> contador2.setText(num2+"1")
            R.id.btn2 -> contador2.setText(num2+"2")
            R.id.btn3 -> contador2.setText(num2+"3")
            R.id.btn4 -> contador2.setText(num2+"4")
            R.id.btn5 -> contador2.setText(num2+"5")
            R.id.btn6 -> contador2.setText(num2+"6")
            R.id.btn7 -> contador2.setText(num2+"7")
            R.id.btn8 -> contador2.setText(num2+"8")
            R.id.btn9 -> contador2.setText(num2+"9")
            R.id.btnPunto -> contador2.setText(num2+".")
        }
    }

    fun clicOperacion(view: View){
        var num2 = contador2.text.toString()
        numero1 = num2.toString().toDouble()
        contador2.setText("")
        when(view.id){
            R.id.btnSumar -> {
                contador1.setText(num2+"+")
                oper = 1
            }
            R.id.btnRestar ->{
                contador1.setText(num2+"-")
                oper = 2
            }
            R.id.btnMult ->{
                contador1.setText(num2+"*")
                oper = 3
            }
            R.id.btnDividir -> {
                contador1.setText(num2+"/")
                oper = 4
            }
        }
    }
}