package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.calculator.models.Calculator

class MainActivity : AppCompatActivity() {
    lateinit var edtNumber1:EditText
    lateinit var edtNumber2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumber1 = findViewById(R.id.editTextNumber)
        edtNumber2 = findViewById(R.id.editTextNumber2)
    }
    fun buttonClick(v: View) {
        var ans = 0.0
        val calculator = Calculator(
            edtNumber1.text.toString().toDouble(),
            edtNumber2.text.toString().toDouble()
        )
        when (v.id) {
            R.id.additionButton -> ans = calculator.add()
            R.id.substractionButton -> ans = calculator.subtract()
            R.id.multipleButton -> ans = calculator.multiply()
            R.id.divideButton -> ans = calculator.divide()
        }
        println(ans)//this will print the output on the terminal
        val intent = Intent(this, Activity02::class.java)
        intent.putExtra("answer", ans)
        startActivity(intent)
        finish()
    }
}