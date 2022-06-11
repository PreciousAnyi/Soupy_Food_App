package com.project.soupyfoodapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.soupyfoodapp.databinding.FragmentFoodDetailsBinding
import kotlin.properties.Delegates


class FoodDetailsFragment : Fragment() {

    private var _binding: FragmentFoodDetailsBinding? = null
    private val binding get() = _binding !!
    private lateinit var food: String
    private lateinit var price: String
    private  var image by Delegates.notNull<Int>()

    companion object {
        const val Food = "food"
        const val Price = "price"
        const val ImageView = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            food = it?.getString(Food).toString()
            price = it?.getString(Price).toString()
            if (it != null) {
                image = it.getInt(ImageView)
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFoodDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

            super.onViewCreated(view, savedInstanceState)
            binding.foodDetailsTV.text = food
            binding.foodDetailsPriceTV.text = price
            binding.foodDetailsIV.setImageResource(image)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}