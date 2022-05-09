package com.project.soupyfoodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.soupyfoodapp.adapter.FoodAdapter
import com.project.soupyfoodapp.model.Food

class MainActivity : AppCompatActivity() {

    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            //when dark mode is enabled, set the theme to this
            setTheme(R.style.Theme_SoupyFoodAppDark)
        } else{
            //default app theme
            setTheme(R.style.Theme_SoupyFoodApp)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializing the recyclerview
       var recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        //setting the layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        //list of food items array list
        foodList = ArrayList()

        //adding food image, price and name
        foodList.add(Food(R.drawable.afang,"N 1500","Afang Soup"))
        foodList.add(Food(R.drawable.archi,"N 1300","Archi Soup"))
        foodList.add(Food(R.drawable.banga,"N 1800","Banga Soup"))
        foodList.add(Food(R.drawable.bitter_leaf_soup,"N 1200","Bitter Leaf Soup"))

        foodList.add(Food(R.drawable.afang,"N 1500","Afang Soup"))
        foodList.add(Food(R.drawable.archi,"N 1300","Archi Soup"))
        foodList.add(Food(R.drawable.banga,"N 1800","Banga Soup"))
        foodList.add(Food(R.drawable.bitter_leaf_soup,"N 1200","Bitter Leaf Soup"))

        foodList.add(Food(R.drawable.afang,"N 1500","Afang Soup"))
        foodList.add(Food(R.drawable.archi,"N 1300","Archi Soup"))
        foodList.add(Food(R.drawable.banga,"N 1800","Banga Soup"))
        foodList.add(Food(R.drawable.bitter_leaf_soup,"N 1200","Bitter Leaf Soup"))

        foodList.add(Food(R.drawable.afang,"N 1500","Afang Soup"))
        foodList.add(Food(R.drawable.archi,"N 1300","Archi Soup"))
        foodList.add(Food(R.drawable.banga,"N 1800","Banga Soup"))
        foodList.add(Food(R.drawable.bitter_leaf_soup,"N 1200","Bitter Leaf Soup"))

        foodList.add(Food(R.drawable.afang,"N 1500","Afang Soup"))
        foodList.add(Food(R.drawable.archi,"N 1300","Archi Soup"))
        foodList.add(Food(R.drawable.banga,"N 1800","Banga Soup"))
        foodList.add(Food(R.drawable.bitter_leaf_soup,"N 1200","Bitter Leaf Soup"))

        foodList.add(Food(R.drawable.afang,"N 1500","Afang Soup"))
        foodList.add(Food(R.drawable.archi,"N 1300","Archi Soup"))
        foodList.add(Food(R.drawable.banga,"N 1800","Banga Soup"))
        foodList.add(Food(R.drawable.bitter_leaf_soup,"N 1200","Bitter Leaf Soup"))



        foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter
    }
}