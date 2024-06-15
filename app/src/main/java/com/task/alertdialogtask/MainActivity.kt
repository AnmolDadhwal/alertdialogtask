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
    var cal: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        etnum=findViewById(R.id.etnum)
        cal=findViewById(R.id.btncal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cal?.setOnClickListener {
            if (etnum?.text?.trim().isNullOrEmpty()){
                etnum?.error="Enter any number"
            }else{
                AlertDialog.Builder(this).apply {
                    setTitle("Hello")
                    setMessage("Press ADD to add ${etnum?.text.toString().trim()} \nPress SUB to subtract ${etnum?.text.toString().trim()} \nPress 0 to reset")
                    setCancelable(false)
                    setPositiveButton("Add${etnum?.text.toString().trim()}"){_,_->
                        etnum?.setText("${etnum?.text.toString().trim().toInt()+etnum?.text.toString().trim().toInt()}")
                    }
                    setNegativeButton("Sub${etnum?.text.toString().trim()}"){_,_->
                        etnum?.setText("${etnum?.text.toString().trim().toInt()-etnum?.text.toString().trim().toInt()}")
                        }
                    setNeutralButton("0"){_,_->
                        etnum?.setText("0")
                    }
                    show()
                }
            }
        }
    }
}