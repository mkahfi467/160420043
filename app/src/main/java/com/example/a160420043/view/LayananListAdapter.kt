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
import com.example.a160420043.model.Layanan
import com.example.a160420043.util.loadImage

class LayananListAdapter(val layananList:ArrayList<Layanan>)
    :RecyclerView.Adapter<LayananListAdapter.LayananViewHolder>()
{
    class LayananViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LayananViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layanan_list_item, parent, false)
        return LayananViewHolder(view)

    }

    override fun onBindViewHolder(holder: LayananViewHolder, position: Int) {
        val txtNama = holder.view.findViewById<TextView>(R.id.txtNamaLayanan)
        txtNama.text = layananList[position].nama

        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetailLayanan)
        btnDetail.setOnClickListener {
            val layana_id = layananList[position].id

            val action = LayananListFragmentDirections.actionItemLayananToLayananListDetailFragment(layana_id.toString())
            Navigation.findNavController(it).navigate(action)
        }

        val imageView = holder.view.findViewById<ImageView>(R.id.imgViewLayanan)
        imageView.loadImage(layananList[position].photoUrl)
    }

    override fun getItemCount(): Int {
        return layananList.size
    }

    fun updateJadwalList(newLayananList: ArrayList<Layanan>) {
        layananList.clear()
        layananList.addAll(newLayananList)
        notifyDataSetChanged()
    }
}