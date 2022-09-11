package com.example.bmicalculator

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        info.visibility = View.INVISIBLE
        btn.setOnClickListener {
        //    info.visibility = View.VISIBLE
            var weight: Double = masaEdit.text.toString().toDouble()
            var height: Double = inaltimeaEdit.text.toString().toDouble()
            var imc:Double = (weight/height/height)*10000
                info.visibility = View.VISIBLE
            info.text="IMC = ${String.format("%.2f",imc)} ${imcRes(imc)}"
        }
    }
    fun imcRes(imc:Double):String {
        var ans = ""
        if (imc < 18.5) {
            ans = "Subponderal"
        } else if (imc > 18.5 && imc < 24.9) {
            ans = "Greutate noramlă"
        } else if (imc > 25 && imc < 29.9) {
            ans = "Obezitate"
        } else {
            ans = "Obezitate morbidă"
        }
        return ans
    }
}