package com.example.testcity.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.testcity.R
import com.example.testcity.view.CircularImageView

class CategoriesAdapter(private val categoriesList: List<Categories>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    var rotationAngel = 0F
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_item, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val categories = categoriesList[position]
        holder.image.setImageResource(categories.image)
        holder.image.rotation = rotationAngel
        holder.itemName.text = categories.itemName
        holder.itemTypeName.text = categories.itemTypeName
        holder.itemColor.setBackgroundColor(categories.imageColor)
    }

    override fun getItemCount(): Int = categoriesList.size

    class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemColor: LinearLayoutCompat = view.findViewById(R.id.ll_image_color)
        val itemName: TextView = view.findViewById(R.id.tv_item_name)
        val itemTypeName: TextView = view.findViewById(R.id.tv_item_count)
        val image: CircularImageView = view.findViewById(R.id.categories_item_photo)
    }
}

