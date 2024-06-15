package com.task.alertdialogtask

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var etnum: EditText?=null
    var btncal: Button?=null
    var array= arrayOf("Press Add to add${etnum},Press - to Sub ${etnum},Press 0 to reset")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        etnum=findViewById(R.id.etnum)
        btncal=findViewById(R.id.btncal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btncal?.setOnClickListener {
            if (etnum?.text?.trim().isNullOrEmpty()){
                etnum?.error="Enter any number"
            }else{
                AlertDialog.Builder(this).apply {
                    setTitle("Hello")
                    setSingleChoiceItems(array,0,{_,_,->})
                    setPositiveButton("Add${etnum}"){_,_->
                        etnum.setText("${etnum.text.toString().trim().toInt().plus("${etnum}")}")
                    }
                    setNegativeButton("Sub${etnum}"){_,_->
                        etnum.setText("${etnum.text.toString().trim().toInt().minus("${etnum}")}")
                        }
                    setNeutralButton("0${etnum}"){_,_->
                        etnum.setText("0")
                    }
                        setCancelable(false)
                }
            }
        }
    }
}