package com.example.testcity.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testcity.R

class PopularItemAdapter(private val popularItemList: List<Popular>) :
    RecyclerView.Adapter<PopularItemAdapter.PopularItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_item, parent, false)
        return PopularItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularItemViewHolder, position: Int) {
        val popularItem = popularItemList[position]
        holder.popularName.text = popularItem.itemName
        holder.popularImageWeight.text = popularItem.itemWeight
        holder.popularImage.setImageResource(popularItem.image)
        holder.popularSmallImage.setImageResource(popularItem.smallImage)
    }

    override fun getItemCount(): Int {
        return popularItemList.size
    }

    class PopularItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val popularName: TextView = view.findViewById(R.id.tv_popular_name)
        val popularImageWeight: TextView = view.findViewById(R.id.tv_popular_image_weight)
        val popularImage: ImageView = view.findViewById(R.id.iv_popular_image)
        val popularSmallImage: ImageView = view.findViewById(R.id.iv_popular_smallImage)
    }
}
