package com.example.testdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DBList : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var location: EditText
    lateinit var myRV: RecyclerView
    lateinit var dbhr:DBHlpr
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dblist)
        name=findViewById(R.id.name)
        location=findViewById(R.id.location)
        dbhr=DBHlpr(applicationContext)
        myRV=findViewById(R.id.rv)
        var addbtn=findViewById<Button>(R.id.add)

        addbtn.setOnClickListener {
            dbhr.savedat(name.text.toString(),location.text.toString())
            updateRV(dbhr.readData())
        }
        updateRV(dbhr.readData())
    }
    fun updateRV(data: ArrayList<Users>){
        myRV.adapter = RVAdapter(this,data)
        myRV.layoutManager = LinearLayoutManager(this)
    }


}