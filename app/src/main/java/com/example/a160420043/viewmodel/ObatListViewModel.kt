package com.example.a160420043.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160420043.model.Jadwal
import com.example.a160420043.model.Obat

class ObatListViewModel: ViewModel() {
    val obatsLD = MutableLiveData<ArrayList<Obat>>()
    val obatDetailLD = MutableLiveData<ArrayList<Obat>>()

    val obat1 =
        Obat("16055","Adem Sari","Minuman herbal", "https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/19284/19284_1637307873.3592__540x540.jpg")
    val obat2 =
        Obat("13312","Betadine","Antiseptik", "https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/14381/14381_1624258523.7964__540x540.jpg")
    val obat3 =
        Obat("11204","CTM","Antihistamine", "https://images.tokopedia.net/img/cache/700/hDjmkQ/2023/2/15/ba7662c5-526c-4dff-87cb-7cb04463fba8.jpg.webp")
    val obat4 =
        Obat("10001","Dopamin","Obat jantung", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Dopamine_HCl.JPG/1536px-Dopamine_HCl.jpg")

    val ObatList:ArrayList<Obat> = arrayListOf<Obat>(obat1, obat2, obat3, obat4)

    fun refresh() {
        obatsLD.value = ObatList
    }

    fun obatDetail(obatId:String) {
        ObatList.forEachIndexed{ index, data ->
            val id = data.id
            if (id == obatId) {
                val array:ArrayList<Obat> = arrayListOf<Obat>(ObatList[index])
                obatDetailLD.value = array
            }
        }
    }
}