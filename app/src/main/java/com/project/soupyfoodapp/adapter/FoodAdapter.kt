package com.project.soupyfoodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.project.soupyfoodapp.FoodFragmentDirections
import com.project.soupyfoodapp.R
import com.project.soupyfoodapp.model.Food

class FoodAdapter(val foodList: ArrayList<Food>)
    : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){



    class FoodViewHolder(view: View): RecyclerView.ViewHolder(view){
        //initializing the views in item_design xml
        val foodName: TextView = view.findViewById(R.id.food_name)
        val foodPrice: TextView = view.findViewById(R.id.food_price)
        val imageview: ImageView = view.findViewById(R.id.food_image_view)
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
         val action = FoodFragmentDirections.actionFoodFragmentToFoodDetailsFragment(food.name,food.image,food.price)
            holder.itemView.findNavController().navigate(action)

        }
    }

    override fun getItemCount(): Int {
       return foodList.size
    }
}