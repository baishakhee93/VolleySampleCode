package com.baishakhee.volleysamplecode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    var url="https://api.cricapi.com/v1/series?apikey=5d96e58a-40db-42e3-8bd9-a02881ea9a6d&offset=0"
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:MatchesAdaper
    private lateinit var matchModel: MatchModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerView)
        getMatchList()
    }


    private fun getMatchList() {
        val queue: RequestQueue = Volley.newRequestQueue(this)

        // on below line we are creating a variable for request
        // and initializing it with json object request
        val request = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            // this method is called when we get a successful response from API.

            println(response)

            // we are setting the visibility of progress bar as gone.
            //  loadingPB.setVisibility(View.GONE)

            // on below line we are adding a try catch block.
            try {
                var gson = Gson()
                val jsonString = gson.toJson(response)
                println("Match jsonString........." +jsonString)
              matchModel =gson.fromJson(jsonString, MatchModel::class.java)

                //   println("Match info "+ (exampleJson2KtKotlin.nameValuePairs?.data?.nameValuePairData?.info))
             //    println("Match matchList "+ (exampleJson2KtKotlin.nameValuePairs?.data?.nameValuePairData?.matchList))

                 // on below line we are getting data from our response
                 // and setting it in variables.
                 recyclerView.layoutManager = LinearLayoutManager(this)
                 adapter = MatchesAdaper(this, matchModel)
                 // Setting the Adapter with the recyclerview
                 recyclerView.adapter = adapter
            } catch (e: Exception) {
                // on below line we are
                // handling our exception.
                e.printStackTrace()
            }

        }, { error ->
            // this method is called when we get
            // any error while fetching data from our API
            Log.e("TAG", "RESPONSE IS $error")
            // in this case we are simply displaying a toast message.
            Toast.makeText(this, "Fail to get response", Toast.LENGTH_SHORT)
                .show()
        })
        // at last we are adding
        // our request to our queue.
        queue.add(request)    }
}