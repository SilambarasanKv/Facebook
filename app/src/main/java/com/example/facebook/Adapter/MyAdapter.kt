package com.example.facebook.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.example.facebook.Model.Feed
import com.example.facebook.R

class MyAdapter(private val data: List<Feed>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(feed: Feed){
            val name = view.findViewById<TextView>(R.id.txtName)
            val imageView = view.findViewById<ImageView>(R.id.imgPost)
            val text = view.findViewById<TextView>(R.id.txtPostImage)

            name.text = feed.name
            text.text = feed.text

            Glide.with(view.context).load(feed.image).centerCrop().into(imageView)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_newsfeed, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }


}