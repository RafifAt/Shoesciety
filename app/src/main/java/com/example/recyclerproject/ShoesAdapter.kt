package com.example.recyclerproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoesAdapter(private val shoesList: ArrayList<Shoes>) :
    RecyclerView.Adapter<ShoesAdapter.ShoesViewHolder>() {
    class ShoesViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.img_shoes)
        val textMerk : TextView = itemView.findViewById(R.id.tv_shoes_merk)
        val textType : TextView = itemView.findViewById(R.id.tv_shoes_type)
        val textPrice : TextView = itemView.findViewById(R.id.tv_shoes_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shoes, parent,false )
        return  ShoesViewHolder(view)
    }

    override fun getItemCount(): Int {
       return shoesList.size
    }

    override fun onBindViewHolder(holder: ShoesViewHolder, position: Int) {
       val shoes = shoesList[position]
        holder.imageView.setImageResource(shoes.Image)
        holder.textMerk.text = shoes.Merk
        holder.textType.text = shoes.Type
        holder.textPrice.text = shoes.Price
    }
}