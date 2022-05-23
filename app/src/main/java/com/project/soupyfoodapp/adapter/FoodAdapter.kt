package com.project.soupyfoodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.soupyfoodapp.R
import com.project.soupyfoodapp.model.Food

class FoodAdapter(val foodList: ArrayList<Food>)
    : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){

    var onItemClick : ((Food) -> Unit)? = null

    class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //initializing the views in item_design xml
        val foodName: TextView = itemView.findViewById(R.id.food_name)
        val foodPrice: TextView = itemView.findViewById(R.id.food_price)
        val imageview: ImageView = itemView.findViewById(R.id.food_image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_design, parent,false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.foodName.text = food.name
        holder.foodPrice.text = food.price
        holder.imageview.setImageResource(food.image)
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(food)
        }
    }

    override fun getItemCount(): Int {
       return foodList.size
    }
}