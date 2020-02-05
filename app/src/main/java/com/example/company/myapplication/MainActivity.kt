package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    var a: Float = 0.0F


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    
    fun setABC () {
        aValue.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                try {
                    p0.toString().toFloat()
                } catch (E:NumberFormatException) {
                    isSolutionExist.text = "Error"
                    return
                }


            }

        })
    }
}
