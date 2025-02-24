package com.nishiket.task.retrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nishiket.task.R
import com.nishiket.task.retrofit.adapter.UserRecylerViewAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetofitActivity : AppCompatActivity() {
    private lateinit var retrofitInterface:Retrofit
    private lateinit var userRecylerView: RecyclerView
    private lateinit var progress: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retofit)
        // assign Ids using function
        findId()
        // creating Retrofit Reference
        retrofitInterface = RetrofitInstance.getInstance().create(Retrofit::class.java)
        progress.visibility = View.VISIBLE
        userRecylerView.visibility = View.GONE
        // calling this method to get Users details
        getData()


    }

    // function to find Ids of the view
    fun findId(){
        userRecylerView = findViewById(R.id.userRecyclerView)
        progress = findViewById(R.id.progress)
    }

    // function to get the data form API
    fun getData(){
        val call = retrofitInterface.getUsers()
        call.enqueue(object :Callback<List<Users>>{
            override fun onResponse(p0: Call<List<Users>>, p1: Response<List<Users>>) {
                Log.d("TAG", "onResponse: $p1")
                if(p1.isSuccessful && p1.body() != null){
                    userRecylerView.adapter = UserRecylerViewAdapter(p1.body()!!)
                    progress.visibility = View.GONE
                    userRecylerView.visibility = View.VISIBLE
                    userRecylerView.layoutManager = LinearLayoutManager(this@RetofitActivity,LinearLayoutManager.VERTICAL,false)
                    return
                }
                progress.visibility = View.GONE
                Toast.makeText(this@RetofitActivity,"Something Went Wrong",Toast.LENGTH_LONG).show()
            }
            override fun onFailure(p0: Call<List<Users>>, p1: Throwable) {
                progress.visibility = View.GONE
                Toast.makeText(this@RetofitActivity,"Something Went Wrong",Toast.LENGTH_LONG).show()
            }

        })
    }
}