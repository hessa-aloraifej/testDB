package com.example.testdb

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter (val activity:DBList, val list: ArrayList<Users>) : RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = list[position]


        holder.itemView.apply {


            textView.text = " ${position+1} - ${data.name}"
            textView2.text = " ${position+1} - ${data.pk}"
            ll.setOnClickListener{
                val intent= Intent(activity,UpdateDel::class.java)
                intent.putExtra("id",data.pk)
                activity.startActivity(intent)
                println("hhh${data.pk}")
            }
            button2.setOnClickListener(){
                //activity. delete(data.id)
//                val intent= Intent(activity,UpdateDel::class.java)
//                intent.putExtra("id",data.id)
//                activity.startActivity(intent)

            }
            button3.setOnClickListener {
               // activity.update(data.id)
//                val intent= Intent(activity,UpdateDel::class.java)
//                intent.putExtra("id",data.id)
//                println("hhh${data.id}")
//
//                activity.startActivity(intent)
            }

        }
    }

    override fun getItemCount(): Int = list.size
}