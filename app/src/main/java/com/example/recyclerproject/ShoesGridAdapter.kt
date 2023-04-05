package com.example.recyclerproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ShoesGridAdapter(val shoesList: ArrayList<Shoes>) :
    RecyclerView.Adapter<ShoesGridAdapter.GridViewHolder>(){

    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.img_shoes)
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.grid_shoes, viewGroup,false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(shoesList[position].Image)
            .apply(RequestOptions().override(200,300))
            .into(holder.imageView)
        holder.itemView.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
       return shoesList.size
    }

}

