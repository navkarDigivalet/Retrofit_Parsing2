package com.example.retrofit_parsing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataset : ArrayList<responseDataClassItem>): RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        val txtUserId : TextView
        val txtId : TextView
        val txtTitle : TextView
        val txtBody : TextView


        init {
            txtUserId = view.findViewById(R.id.edtUserId)
            txtId = view.findViewById(R.id.edtId)
            txtTitle = view.findViewById(R.id.edtTitle)
            txtBody = view.findViewById(R.id.edtBody)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.postslist,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.txtUserId.text = dataset[position].userId.toString()
        holder.txtId.text = dataset[position].id.toString()
        holder.txtTitle.text = dataset[position].title
        holder.txtBody.text = dataset[position].body


    }
}