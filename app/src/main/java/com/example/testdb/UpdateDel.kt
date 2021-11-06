package com.example.testdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class UpdateDel : AppCompatActivity() {
    lateinit var dbhr:DBHlpr
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_del)
        var tv=findViewById<TextView>(R.id.textView3)
        dbhr=DBHlpr(applicationContext)
        var newname=findViewById<EditText>(R.id.newname)
        var newlocation=findViewById<EditText>(R.id.newlocation)
        var delbtn=findViewById<Button>(R.id.button4)
        var editbtn=findViewById<Button>(R.id.button5)
        var id= intent.getIntExtra("id",0)
        tv.text=id.toString()
        delbtn.setOnClickListener {

                delete(id)

        }
        editbtn.setOnClickListener {

                update(id,newname.text.toString(),newlocation.text.toString())

        }
    }

        fun delete(s: Int){
        dbhr.del(s)

    }
    fun update(s1: Int, s2:String, s3:String){
        dbhr.edit(s1,s2,s3)

    }
}