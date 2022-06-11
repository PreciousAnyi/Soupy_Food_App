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
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.project.soupyfoodapp.adapter.FoodAdapter
import com.project.soupyfoodapp.model.Food

class MainActivity : AppCompatActivity() {

    private lateinit var foodList: ArrayList<Food>

    private lateinit var recyclerView: RecyclerView
    private lateinit var navController: NavController




    override fun onCreate(savedInstanceState: Bundle?) {


        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            //when dark mode is enabled, set the theme to this
            setTheme(R.style.Theme_SoupyFoodAppDark)
        } else {
            //default app theme
            setTheme(R.style.Theme_SoupyFoodApp)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController)

        //initializing the recyclerview
     /*   recyclerView = findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)*/






    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}




