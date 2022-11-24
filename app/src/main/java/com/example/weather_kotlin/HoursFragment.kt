package com.example.weather_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather_kotlin.databinding.FragmentHoursBinding
import com.example.weather_kotlin.databinding.FragmentMainBinding


class HoursFragment : Fragment() {

    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHoursBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        rcView.adapter = adapter
        val list = listOf(
            WeatherModel("","6/66/6666",
                "Hot as Hell",
                "70C",
                "",
                "",
                "",
                ""),

            WeatherModel("","6/66/6666",
                "Hot as Hell",
                "70C",
                "",
                "",
                "",
                ""),

            WeatherModel("","6/66/6666",
                "Hot as Hell",
                "70C",
                "",
                "",
                "",
                ""),
        )
        adapter.submitList(list)
    }

    companion object {
        fun newInstance(): HoursFragment{
            return HoursFragment()
        }
    }
}