package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setABC()
    }

    private fun setABC () {

        x1Value.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() != "") {
                    checkRoot1 = true
                    aValue.setText("1.0")
                    isSolutionExist.text = "One root"
                    if (checkRoot1 && checkRoot2) {
                        isSolutionExist.text = "Two roots"

                        if (x1Value.text.toString().toFloat()==x2Value.text.toString().toFloat()){
                            isSolutionExist.text = "One root"
                        }
                    }
                } else {
                    if (!checkRoot2){
                        isSolutionExist.text = ""
                    } else {
                        isSolutionExist.text = "One root"
                    }
                    checkRoot1 = false
                }

            }

        })

        x2Value.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() != "") {
                    checkRoot2 = true
                    aValue.setText("1.0")
                    isSolutionExist.text = "One root"
                    if (checkRoot1 && checkRoot2) {

                        isSolutionExist.text = "Two roots"
                        if (x1Value.text.toString().toFloat()==x2Value.text.toString().toFloat()){
                            isSolutionExist.text = "One root"
                        }
                    }
                } else {
                    if (!checkRoot1){
                        isSolutionExist.text = ""
                    } else {
                        isSolutionExist.text = "One root"
                    }
                    checkRoot2 = false
                }
            }

        })

        aValue.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                a1 = false
                try {
                    p0.toString().toFloat()
                } catch (E:NumberFormatException) {
                    isSolutionExist.text = "Error"
                    return
                }  finally {
                    tryDecide()
                }
                a = p0.toString().toFloat()
                a1 = true
                tryDecide()

            }
        })


        bValue.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                b1 = false
                try {
                    p0.toString().toFloat()
                } catch (E:NumberFormatException) {
                    isSolutionExist.text = "Error"
                    return
                } finally {
                    tryDecide()
                }
                b = p0.toString().toFloat()
                b1 = true
                tryDecide()

            }
        })

        cValue.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                c1 = false
                try {
                    p0.toString().toFloat()
                } catch (E:NumberFormatException) {
                    isSolutionExist.text = "Error"
                    return
                } finally {
                    tryDecide()
                }
                c = p0.toString().toFloat()
                c1 = true
                tryDecide()

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
