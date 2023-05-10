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
public class JadwalListViewModel:ViewModel() {
    val jadwalsLD = MutableLiveData<ArrayList<Jadwal>>()
    val jadwalDetailLD = MutableLiveData<ArrayList<Jadwal>>()
//    val jadwalLoadErrorLD = MutableLiveData<Boolean>()
//    val loadingLD = MutableLiveData<Boolean>()

    val jadwal1 =
        Jadwal("16055","dr. Stella","senin", "https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1527739362/image_doctor/dr.%20stella%20shirley%20mansur.jpg.jpg")
    val jadwal2 =
        Jadwal("13312","dr. Paulus","selasa", "https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1551767727/image_doctor/dr-paulus-sugiantro.jpg.jpg")
    val jadwal3 =
        Jadwal("11204","dr. Soetojo","rabu", "https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1501041580/image_doctor/%282%29%20Prof.%20Dr.%20Soetojo%2C%20dr.%2C%20SpU%20%28K%29edit.jpg.jpg")

    val jadwalList:ArrayList<Jadwal> = arrayListOf<Jadwal>(jadwal1, jadwal2, jadwal3)

    // VERSION 2
//    val TAG = "VOLLEY"
//    private var queue:RequestQueue? = null

    public fun refresh() {
//        val jadwal1 =
//            Jadwal("16055","dr. Stella","senin", "https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1527739362/image_doctor/dr.%20stella%20shirley%20mansur.jpg.jpg")
////            Jadwal("16055","dr. Stella","senin", "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
//
//        val jadwal2 =
//            Jadwal("13312","dr. Paulus","selasa", "https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1551767727/image_doctor/dr-paulus-sugiantro.jpg.jpg")
////            Jadwal("13312","dr. Paulus","selasa", "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
//
//        val jadwal3 =
//            Jadwal("11204","dr. Soetojo","rabu", "https://res.cloudinary.com/dk0z4ums3/image/upload/w_100,h_100,c_thumb,dpr_2.0/v1501041580/image_doctor/%282%29%20Prof.%20Dr.%20Soetojo%2C%20dr.%2C%20SpU%20%28K%29edit.jpg.jpg")
////            Jadwal("11204","dr. Soetojo","rabu", "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
//
//        val jadwalList:ArrayList<Jadwal> = arrayListOf<Jadwal>(jadwal1, jadwal2, jadwal3)

        jadwalsLD.value = jadwalList
//        jadwalLoadErrorLD.value = false
//        loadingLD.value = false

        // VERSION 2
//        loadingLD.value = true
//        jadwalLoadErrorLD.value = false
//
//        queue = Volley.newRequestQueue(getApplication())
////        val url = "https://gist.githubusercontent.com/kahfisem06/951d3c2a724ae2b1573ae07e4981d244/raw/71f769a8e58b016f5e0af40565647486189dfbba/jadwal.php"
//        val url = "https://gist.githubusercontent.com/kahfisem06/951d3c2a724ae2b1573ae07e4981d244/raw/3230644e044f2f20259186b6aba56d217d640930/jadwal.php"
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            {
//                val sType = object: TypeToken<ArrayList<Jadwal>>() { }.type
//                val result = Gson().fromJson<ArrayList<Jadwal>>(it, sType)
//                jadwalsLD.value = result
//                loadingLD.value = false
//
//                Log.d("showvolley", result.toString())
//            },
//            {
//                Log.d("showvolley", it.toString())
//                jadwalLoadErrorLD.value = false
//                loadingLD.value = false
//            })
//        stringRequest.tag = TAG
//        queue?.add(stringRequest)
    }

    fun searchId(jadwalId:String) {
        jadwalList.forEachIndexed{ index, data ->
            val id = data.id
            if (id == jadwalId) {
                val array:ArrayList<Jadwal> = arrayListOf<Jadwal>(jadwalList[index])
                jadwalDetailLD.value = array
            }
        }
    }
}