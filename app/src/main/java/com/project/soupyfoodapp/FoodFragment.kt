package com.project.soupyfoodapp

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.project.soupyfoodapp.adapter.FoodAdapter
import com.project.soupyfoodapp.databinding.FragmentFoodBinding
import com.project.soupyfoodapp.model.Food


class FoodFragment : Fragment(R.layout.fragment_food) {




    // TODO: Rename and change types of parameters
    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding !!
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var recyclerView: RecyclerView
    private var isGridLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFoodBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerview
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
       /* foodAdapter.onItemClick = {
            findNavController().navigate(R.id.action_foodFragment_to_foodDetailsFragment)
           *//* val intent = Intent(requireContext(), FoodDetailsActivity::class.java)
            intent.putExtra("food", it)
            startActivity(intent)*//*

        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater): Boolean {
        //inflate the layout
        inflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu?.findItem(R.id.switch_action)
        if (layoutButton != null) {
            setIcon(layoutButton)
        }

        return true
    }
    private fun chooseLayout(){
        if (isGridLayoutManager){
            recyclerView.layoutManager = GridLayoutManager(requireContext(),2)

        } else {
            recyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        }
        recyclerView.adapter = foodAdapter

    }
    private fun setIcon(menuItem: MenuItem) {
        if (menuItem == null) return

        menuItem.icon =
            if (isGridLayoutManager)
                ContextCompat.getDrawable(requireContext(),R.drawable.ic_grid)
            else {
                ContextCompat.getDrawable(requireContext(),R.drawable.ic_staggered_grid)
            }

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