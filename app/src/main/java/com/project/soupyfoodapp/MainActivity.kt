package com.project.soupyfoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridLayout
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.project.soupyfoodapp.adapter.FoodAdapter
import com.project.soupyfoodapp.model.Food

class MainActivity : AppCompatActivity() {

    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var recyclerView: RecyclerView

    private var isGridLayoutManager = true


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
        recyclerView= findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)



        //list of food items array list
        foodList = ArrayList()

        //adding food image, price and name
        foodList.add(Food(R.drawable.afang,"N 1500","Afang Soup"))
        foodList.add(Food(R.drawable.archi,"N 1300","Archi Soup"))
        foodList.add(Food(R.drawable.banga,"N 1800","Banga Soup"))
        foodList.add(Food(R.drawable.bitter_leaf_soup,"N 1200","Olugbo Soup"))

        foodList.add(Food(R.drawable.afang,"N 1500","Afang Soup"))
        foodList.add(Food(R.drawable.archi,"N 1300","Archi Soup"))
        foodList.add(Food(R.drawable.banga,"N 1800","Banga Soup"))
        foodList.add(Food(R.drawable.bitter_leaf_soup,"N 1200","Olugbo Soup"))

        foodList.add(Food(R.drawable.afang,"N 1500","Afang Soup"))
        foodList.add(Food(R.drawable.archi,"N 1300","Archi Soup"))
        foodList.add(Food(R.drawable.banga,"N 1800","Banga Soup"))
        foodList.add(Food(R.drawable.bitter_leaf_soup,"N 1200","Olugbo Soup"))

        foodList.add(Food(R.drawable.afang,"N 1500","Afang Soup"))
        foodList.add(Food(R.drawable.archi,"N 1300","Archi Soup"))
        foodList.add(Food(R.drawable.banga,"N 1800","Banga Soup"))
        foodList.add(Food(R.drawable.bitter_leaf_soup,"N 1200","Olugbo Soup"))

        foodList.add(Food(R.drawable.afang,"N 1500","Afang Soup"))
        foodList.add(Food(R.drawable.archi,"N 1300","Archi Soup"))
        foodList.add(Food(R.drawable.banga,"N 1800","Banga Soup"))
        foodList.add(Food(R.drawable.bitter_leaf_soup,"N 1200","Olugbo Soup"))

        foodList.add(Food(R.drawable.afang,"N 1500","Afang Soup"))
        foodList.add(Food(R.drawable.archi,"N 1300","Archi Soup"))
        foodList.add(Food(R.drawable.banga,"N 1800","Banga Soup"))
        foodList.add(Food(R.drawable.bitter_leaf_soup,"N 1200","Olugbo Soup"))


        //setting adapter and recyclerview layout
        foodAdapter = FoodAdapter(foodList)
        chooseLayout()


        foodAdapter.onItemClick = {
            val intent = Intent(this,FoodDetailsActivity::class.java)
            intent.putExtra("food", it)
            startActivity(intent)
        }
    }
    private fun chooseLayout(){
        if (isGridLayoutManager){
            recyclerView.layoutManager = GridLayoutManager(this,2)

        } else {
            recyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        }
        recyclerView.adapter = foodAdapter

    }
    private fun setIcon(menuItem: MenuItem) {
        if (menuItem == null) return

        menuItem.icon =
            if (isGridLayoutManager)
                ContextCompat.getDrawable(this,R.drawable.ic_grid)
            else {
                ContextCompat.getDrawable(this,R.drawable.ic_staggered_grid)
            }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //inflate the layout
        menuInflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu?.findItem(R.id.switch_action)
        if (layoutButton != null) {
            setIcon(layoutButton)
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.switch_action -> {
                isGridLayoutManager = !isGridLayoutManager
                chooseLayout()
                setIcon(item)
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}