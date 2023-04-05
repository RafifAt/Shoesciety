package com.example.recyclerproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (private val context: Context, private val
items: ArrayList<User>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_item, parent, false))




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }

    override fun getItemCount(): Int = items.size
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var txtUserName: TextView = itemView.findViewById(R.id.txtName)
        private var txtUserEmail: TextView = itemView.findViewById(R.id.txtEmail)
        private var txtUserDate: TextView = itemView.findViewById(R.id.txtDate)

        fun bindItem(item: User){
            txtUserName.text = item.nama
            txtUserEmail.text = item.email
            txtUserDate.text = item.date

        }

    }
}