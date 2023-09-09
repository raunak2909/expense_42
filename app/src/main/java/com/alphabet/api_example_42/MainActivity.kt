package com.alphabet.api_example_42

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.alphabet.api_example_42.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiHelper = ApiHelper.create()

        //For searching Wallpaper
        apiHelper.searchWallpaper("nXWH9BLpCYtVtyjDTbJB3Hf20uneSxZcYisVLVmNDV4PamGm6EeVDgZm","Lion").enqueue(object : Callback<PhotoDataModel>{
            override fun onResponse(call: Call<PhotoDataModel>, response: Response<PhotoDataModel>) {
                if(response.code()==200){
                    response.body()?.let {
                        Log.d("Response", "${response.body()!!.total_results}")

                        val arrImg = ArrayList<String>()

                        for (photo in response.body()!!.photos){
                            arrImg.add(photo.src.portrait)
                        }

                        Glide.with(this@MainActivity).load(arrImg[0]).into(binding.imageView)


                    }
                }
            }

            override fun onFailure(call: Call<PhotoDataModel>, t: Throwable) {
                Log.d("Network Error", "${t.message}")
                t.printStackTrace()
            }

        })



    }
}