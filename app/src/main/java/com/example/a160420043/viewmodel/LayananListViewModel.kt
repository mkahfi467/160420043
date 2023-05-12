package com.example.a160420043.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160420043.model.Jadwal
import com.example.a160420043.model.Layanan
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LayananListViewModel(application: Application): AndroidViewModel(application) {
    val layanansLD = MutableLiveData<ArrayList<Layanan>>()
    val layananDetailLD = MutableLiveData<Layanan>()

    // VERSION 2
    val TAG = "VOLLEY"
    private var queue: RequestQueue? = null

    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://160420043-160420098-160720049.000webhostapp.com/layanan_list.php"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object: TypeToken<ArrayList<Layanan>>() { }.type
                val result = Gson().fromJson<ArrayList<Layanan>>(it, sType)
                layanansLD.value = result
            },
            {
                Log.d("showvolley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun searchId(layananId:String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://160420043-160420098-160720049.000webhostapp.com/layanan_list.php?id=$layananId"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object: TypeToken<Layanan>() { }.type
                val result = Gson().fromJson<Layanan>(it, sType)
                layananDetailLD.value = result
            },
            {
                Log.d("showvolley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}