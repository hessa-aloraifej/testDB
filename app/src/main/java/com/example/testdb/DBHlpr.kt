package com.example.testdb

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHlpr(context  : Context) : SQLiteOpenHelper(context,"userInfo.dp",null,1) {
    var sqLiteDatabase: SQLiteDatabase =writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if(db!=null){
            db.execSQL("create table UserI (pk integer primary key autoincrement,Namess text,Locationss text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
    fun savedat(s1:String,s2:String){
        val cv= ContentValues()
        cv.put("Namess",s1)
        cv.put("Locationss",s2)
        sqLiteDatabase.insert("UserI",null,cv)

    }

    @SuppressLint("Range")
    fun readData(): ArrayList<Users> {
        val list: ArrayList<Users> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from UserI"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {

               var name = result.getString(result.getColumnIndex("Namess"))
               var location= result.getString(result.getColumnIndex("Locationss")).toString()
                list.add(Users(0,name,location))
            }
            while (result.moveToNext())
        }
        return list
    }



    fun del(s1: Int) {
        sqLiteDatabase = writableDatabase
        sqLiteDatabase.delete("UserI", "pk=?", arrayOf(s1.toString()))
    }
    fun edit(s1: Int, s2:String, s3:String){
        sqLiteDatabase=writableDatabase
        val cv=ContentValues()
        cv.put("Namess",s2)
        cv.put("Locationss",s3)
        sqLiteDatabase.update("UserI",cv,"pk=?", arrayOf(s1.toString()))
    }


}
