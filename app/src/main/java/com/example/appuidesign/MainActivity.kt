package com.example.appuidesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvname: EditText=findViewById(R.id.name)
        val tvcgpa:EditText=findViewById(R.id.cgpa)
        val savebtn:Button=findViewById(R.id.savebtn)
        val loadbtn: Button = findViewById(R.id.loadbtn)

        savebtn.setOnClickListener {
            val name= tvname.text.toString()
            val cgpa= tvcgpa.text.toString()


            val file = File(getExternalFilesDir(null),"student.txt")
            val fos=FileOutputStream(file,false)
            fos.write("$name,$cgpa".toByteArray())
            fos.close()
            tvname.setText("")
            tvcgpa.setText("")
            Toast.makeText(this@MainActivity,"Info Loaded",Toast.LENGTH_LONG)
        }
        loadbtn.setOnClickListener {
            val file= File(getExternalFilesDir(null),"student.txt")
            val fis= FileInputStream(file)
            val isr=InputStreamReader(fis)
            val br=BufferedReader(isr)
            val line:String
            line = br.readLine()
            var parts=line.split(",")
            tvname.setText(parts[0])
            tvcgpa.setText(parts[1])
            Toast.makeText(this@MainActivity,"Info Loaded",Toast.LENGTH_LONG)
        }
    }



}