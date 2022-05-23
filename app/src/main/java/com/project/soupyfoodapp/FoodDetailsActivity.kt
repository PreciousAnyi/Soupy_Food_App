package com.project.soupyfoodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.project.soupyfoodapp.model.Food

class FoodDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        val food = intent.getParcelableExtra<Food>("food")
        if (food != null){
            val textView : TextView = findViewById(R.id.foodDetailsTV)
            val priceTextView : TextView = findViewById(R.id.foodDetailsPriceTV)
            val imageView : ImageView = findViewById(R.id.foodDetailsIV)

            textView.text = food.name
            priceTextView.text = food.price
            imageView.setImageResource(food.image)
        }
    }
}