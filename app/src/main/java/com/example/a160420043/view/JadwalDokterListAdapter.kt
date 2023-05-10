package com.example.a160420043.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420043.R
import com.example.a160420043.model.Jadwal
import com.example.a160420043.util.loadImage

class JadwalDokterListAdapter(val jadwalDokterList:ArrayList<Jadwal>)
    :RecyclerView.Adapter<JadwalDokterListAdapter.JadwalViewHolder>()
{
    class JadwalViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.jadwal_list_item, parent, false)
        return JadwalViewHolder(view)

    }

    override fun onBindViewHolder(holder: JadwalViewHolder, position: Int) {
        val txtNama = holder.view.findViewById<TextView>(R.id.txtNamaJadwal)
        txtNama.text = jadwalDokterList[position].namaDokter
        val txtHari = holder.view.findViewById<TextView>(R.id.txtHariJadwal)
        txtHari.text = jadwalDokterList[position].hari

        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetailJadwal)
        btnDetail.setOnClickListener {
            val jadwal_id = jadwalDokterList[position].id

            val action = JadwalPraktikListFragmentDirections.actionItemHomeToJadwalPraktikDetail(jadwal_id.toString())
            Log.d("test", jadwal_id.toString())
            Navigation.findNavController(it).navigate(action)
        }

        val imageView = holder.view.findViewById<ImageView>(R.id.imgViewJadwal)
        imageView.loadImage(jadwalDokterList[position].photoUrl)
//        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
    }

    override fun getItemCount(): Int {
        return jadwalDokterList.size
    }

    fun updateJadwalList(newJadwalList: ArrayList<Jadwal>) {
        jadwalDokterList.clear()
        jadwalDokterList.addAll(newJadwalList)
        notifyDataSetChanged()
    }

}