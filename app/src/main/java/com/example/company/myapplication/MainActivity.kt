package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.lang.Exception
import java.lang.Math.sqrt
import java.lang.NumberFormatException
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {


    private var a1: Boolean = false
    private var b1: Boolean = false
    private var c1: Boolean = false
    private var a: Float = 1F
    private var b: Float = 0.0F
    private var c: Float = 0.0F
    private var checkRoot1: Boolean = false
    private var checkRoot2: Boolean = false
    private var vpered: Boolean = true
    private var nazad: Boolean = true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setABC()
    }


    private fun checkErrorX (x:String):Boolean {
        try {
            if (x != "") x.toFloat() else return false
            return true
        } catch (E:NumberFormatException){
            return false
        }
    }

    private fun setABC () {

        x1Value.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (nazad) {
                    vpered = false
                    if (checkErrorX(p0.toString()) || checkErrorX(x2Value.text.toString())) {
                        isSolutionExist.text = "One root"
                        if (checkErrorX(p0.toString()) && !checkErrorX(x2Value.text.toString())) {
                            bValue.setText("${(x1Value.text.toString().toFloat()+x1Value.text.toString().toFloat())*(-1)}")
                            cValue.setText("${(x1Value.text.toString().toFloat()*x1Value.text.toString().toFloat())}")
                        } else {
                            isSolutionExist.text = "Two roots"
                            bValue.setText("${(x1Value.text.toString().toFloat()+x2Value.text.toString().toFloat())*(-1)}")
                            cValue.setText("${(x1Value.text.toString().toFloat()*x2Value.text.toString().toFloat())}")
                        }
                        aValue.setText("1.0")
                    } else {
                        isSolutionExist.text = "Error"
                    }
                    vpered = true
                }
            }
        })

        x2Value.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (nazad) {
                    vpered = false
                    if (checkErrorX(p0.toString()) || checkErrorX(x1Value.text.toString())) {
                        isSolutionExist.text = "One root"
                        if (checkErrorX(p0.toString()) && !checkErrorX(x1Value.text.toString())) {
                            bValue.setText("${(x2Value.text.toString().toFloat()+x2Value.text.toString().toFloat())*(-1)}")
                            cValue.setText("${(x2Value.text.toString().toFloat()*x2Value.text.toString().toFloat())}")
                        } else {
                            if (checkErrorX(p0.toString())) {
                                isSolutionExist.text = "Two roots"
                                bValue.setText("${(x1Value.text.toString().toFloat()+x2Value.text.toString().toFloat())*(-1)}")
                                cValue.setText("${(x1Value.text.toString().toFloat()*x2Value.text.toString().toFloat())}")
                            } else {
                                isSolutionExist.text = "Error"
                            }
                        }
                        aValue.setText("1.0")
                    } else {
                        isSolutionExist.text = "Error"
                    }
                    vpered = true
                }
            }
        })

        aValue.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })


        bValue.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

        cValue.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }

    private fun tryDecide () {
        if (a1 && b1 && c1) {
            var D: Float = b*b-4*a*c
            if ((a==0F) && (b==0F) && (c==0F)) {
                isSolutionExist.text = "Any numbers"
                x1Value.setText("")
                x2Value.setText("")
            }
            if ((a==0f) && (b != 0f)) {
                isSolutionExist.text = "One root"
                var x1: Float = -c/b
                x1Value.setText(x1.toString())
                x2Value.setText("")
                return
            }
            if (D==0F){
                isSolutionExist.text = "One root"
                var x1: Float = -b / (2*a)
                x1Value.setText(x1.toString())
                x2Value.setText(x1.toString())
            }
            if ((a==0f)&&(b==0f)&&(c!=0f)) {
                isSolutionExist.text = "No real roots"
                x1Value.setText("")
                x2Value.setText("")
                return
            }

            if (D > 0) {
                isSolutionExist.text = "Two roots"
                var x1: Float = (-b+sqrt(D))/(2*a)
                x1Value.setText(x1.toString())
                var x2: Float = (-b-sqrt(D))/(2*a)
                x2Value.setText(x2.toString())
            } else {
                isSolutionExist.text = "No real roots"
                x1Value.setText("")
                x2Value.setText("")
            }
        }
        if (b1 && c1) {
            a = 1.0F
            var D: Float = b*b-4*a*c
            if (D==0F){
                isSolutionExist.text = "One root"
                var x1: Float = -b / (2*a)
                x1Value.setText(x1.toString())
                x2Value.setText(x1.toString())
            }
            if (D>0) {
                isSolutionExist.text = "Two roots"
                var x1: Float = (-b + sqrt(D)) / (2 * a)
                x1Value.setText(x1.toString())
                var x2: Float = (-b - sqrt(D)) / (2 * a)
                x2Value.setText(x2.toString())
                return
            } else {
                isSolutionExist.text = "No real roots"
                x1Value.setText("")
                x2Value.setText("")
                return
            }
        }

        if (c1){
            isSolutionExist.text = "No real roots"
            x1Value.setText("")
            x2Value.setText("")
            return
        }

    }
}
