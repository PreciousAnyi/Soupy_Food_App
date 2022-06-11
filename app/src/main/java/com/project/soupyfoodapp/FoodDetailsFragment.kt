package com.project.soupyfoodapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.project.soupyfoodapp.databinding.FragmentFoodBinding
import com.project.soupyfoodapp.databinding.FragmentFoodDetailsBinding
import com.project.soupyfoodapp.model.Food


class FoodDetailsFragment : Fragment() {

    private var _binding: FragmentFoodDetailsBinding? = null !!
    private val binding get() = _binding !!
    /*private val args by navArgs<FoodDetailsFragmentArgs>()*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFoodDetailsBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bundle = arguments

        if (bundle == null){
            Log.d("Confirmation","Fragments did not receive any food")
            return
        }


       /* val food = activity?.intent?.getParcelableExtra<Food>("food")
        if (food != null){
            val textView : TextView = binding.foodDetailsTV
            val priceTextView : TextView = binding.foodDetailsPriceTV
            val imageView : ImageView = binding.foodDetailsIV

            textView.text = food.name
            priceTextView.text = food.price
            imageView.setImageResource(food.image)
        }*/
    }
}