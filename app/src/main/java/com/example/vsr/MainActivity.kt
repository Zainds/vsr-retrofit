package com.example.vsr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    lateinit var retrofit: PlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = RetrofitClient.instance()
        var id = 0
        findViewById<Button>(R.id.bigB).setOnClickListener {
            retrofit.getPostFromItem(id).enqueue(object : Callback<bigboydataItem>{
                override fun onFailure(call: Call<bigboydataItem>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<bigboydataItem>,
                    response: Response<bigboydataItem>
                ) {
                    Log.d("RETROFIT", response.body().toString())
                }

            })
            id++
        }

    }
}