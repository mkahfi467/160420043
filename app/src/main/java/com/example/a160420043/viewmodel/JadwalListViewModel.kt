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
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//class JadwalListViewModel(application: Application):AndroidViewModel(application) {
public class JadwalListViewModel(application: Application): AndroidViewModel(application) {
    val jadwalsLD = MutableLiveData<ArrayList<Jadwal>>()
    val jadwalDetailLD = MutableLiveData<Jadwal>()

    // VERSION 2
    val TAG = "VOLLEY"
    private var queue:RequestQueue? = null

    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())
//        val url = "https://gist.githubusercontent.com/mkahfi467/58011889af2df7b56dca20593867b154/raw/5760735b62255065b58e80df51c4e2f9c7ee1681/jadwal.php"
//        val url = "https://gist.githubusercontent.com/kahfisem06/951d3c2a724ae2b1573ae07e4981d244/raw/71f769a8e58b016f5e0af40565647486189dfbba/jadwal.php"
//        val url = "https://gist.githubusercontent.com/kahfisem06/951d3c2a724ae2b1573ae07e4981d244/raw/9d024f32f957310a6190f4c2326733695ac8c09a/jadwal.php"
        val url = "https://160420043-160420098-160720049.000webhostapp.com/jadwal_list.php"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object: TypeToken<ArrayList<Jadwal>>() { }.type
                val result = Gson().fromJson<ArrayList<Jadwal>>(it, sType)
                jadwalsLD.value = result

                Log.d("showvolley", jadwalsLD.value.toString())
//                Log.d("showvolley", jadwalsLD.value.toString())
            },
            {
                Log.d("showvolley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun searchId(jadwalId:String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://160420043-160420098-160720049.000webhostapp.com/jadwal_list.php?id=$jadwalId"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object: TypeToken<Jadwal>() { }.type
                val result = Gson().fromJson<Jadwal>(it, sType)
                jadwalDetailLD.value = result

                Log.d("showvolley", jadwalsLD.value.toString())
//                Log.d("showvolley", jadwalsLD.value.toString())
            },
            {
                Log.d("showvolley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}