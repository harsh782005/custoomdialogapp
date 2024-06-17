package com.harsh.custoomdialogapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.harsh.custoomdialogapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        // setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
 val btnmain = findViewById<Button>(R.id.mainbtn)
        btnmain.setOnClickListener {
            Dialog(this).apply {
                setContentView(R.layout.layout_dialog)
                show()
                val editText = this.findViewById<EditText>(R.id.edittext)
                val btn1 = this.findViewById<Button>(R.id.btn1)
                val btn2 = this.findViewById<Button>(R.id.btn2)
                btn1.setOnClickListener {
                    if (editText?.text?.toString().isNullOrEmpty()) {
                        editText?.error = resources.getString(R.string.enter)
                    } else {
                        binding?.name?.setText(editText?.text?.toString())
                        this.dismiss()
                    }
                }
                btn2.setOnClickListener {
                    this.dismiss()
                }
            }
        }
    }
}
