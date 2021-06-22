package com.example.facebook

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook.Adapter.MyAdapter
import com.example.facebook.Common.Common
import com.example.facebook.Model.Feed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        val editor: SharedPreferences.Editor = preferences.edit()
        editor.clear()
        editor.apply()

        manager = LinearLayoutManager(this)
        getAllData()
    }

    fun getAllData(){
        Common.retrofitService.getAllData().enqueue(object: Callback<List<Feed>> {
            override fun onFailure(call: Call<List<Feed>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<List<Feed>>, response: Response<List<Feed>>) {
                if(response.isSuccessful){
                    recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply{
                        myAdapter = MyAdapter(response.body()!!)
                        layoutManager = manager
                        adapter = myAdapter
                    }
                }
            }
        })
    }
}