package com.example.weather_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weather_kotlin.databinding.ActivityMainBinding
import org.json.JSONObject

private const val TAG = "MainActivity"
private const val API_KEY = "483a0d3a56ca43d883261050221811"


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment == null){
            val fragment = MainFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,fragment)
                .commit()
        }
    }

    private fun getResult(name: String){
        val url = "https://api.weatherapi.com/v1/current.json" +
                "?key=$API_KEY&q=$name&aqi=no"

        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {response->
                val obj = JSONObject(response)
                val temp = obj.getJSONObject("current")
                Log.d(TAG,"Response: ${temp.getString("temp_c")}")
            },
            {
                Log.d(TAG,"Volley error: $it")
            }
        )
        queue.add(stringRequest)
    }
}