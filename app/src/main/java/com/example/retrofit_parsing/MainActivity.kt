package com.example.retrofit_parsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// https://jsonplaceholder.typicode.com/posts       post - end Point      rest is base Url

lateinit var adapter: CustomAdapter
lateinit var recycler1 : RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        getData()

    }

    private fun getData() {

        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<responseDataClass?> {
            override fun onResponse(
                call: Call<responseDataClass?>,
                response: Response<responseDataClass?>
            ) {

               val responseClass : responseDataClass? = response.body()

                if(responseClass != null){
                    // Log.d("Error" , responseDataClass.toString())

                    adapter = CustomAdapter(responseClass)

                    recycler1 = findViewById(R.id.recycler1)

                    recycler1.layoutManager = LinearLayoutManager(this@MainActivity)

                    recycler1.adapter = adapter

                }


            }

            override fun onFailure(call: Call<responseDataClass?>, t: Throwable) {

                Toast.makeText(this@MainActivity , t.localizedMessage , Toast.LENGTH_SHORT)
                    .show()

            }
        })
    }
}