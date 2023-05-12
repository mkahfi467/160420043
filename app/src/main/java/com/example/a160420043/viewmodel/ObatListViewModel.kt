package com.example.a160420043.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160420043.model.Jadwal
import com.example.a160420043.model.Obat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ObatListViewModel(application: Application): AndroidViewModel(application) {
    val obatsLD = MutableLiveData<ArrayList<Obat>>()
    val obatDetailLD = MutableLiveData<Obat>()

    val TAG = "VOLLEY"
    private var queue: RequestQueue? = null

    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://160420043-160420098-160720049.000webhostapp.com/obat_list.php"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object: TypeToken<ArrayList<Obat>>() { }.type
                val result = Gson().fromJson<ArrayList<Obat>>(it, sType)
                obatsLD.value = result
            },
            {
                Log.d("showvolley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun obatDetail(obatId:String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://160420043-160420098-160720049.000webhostapp.com/obat_list.php?id=$obatId"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object: TypeToken<Obat>() { }.type
                val result = Gson().fromJson<Obat>(it, sType)
                obatDetailLD.value = result
            },
            {
                Log.d("showvolley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}