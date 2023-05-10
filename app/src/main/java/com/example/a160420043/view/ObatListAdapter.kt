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
import com.example.a160420043.model.Obat
import com.example.a160420043.util.loadImage

class ObatListAdapter(val obatList:ArrayList<Obat>)
    : RecyclerView.Adapter<ObatListAdapter.ObatViewHolder>()
{
    class ObatViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.obat_list_item, parent, false)
        return ObatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ObatViewHolder, position: Int) {
        val txtNama = holder.view.findViewById<TextView>(R.id.txtNamaObat)
        txtNama.text = obatList[position].name
        val txtKategori = holder.view.findViewById<TextView>(R.id.txtKategoriObat)
        txtKategori.text = obatList[position].kategori

        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetailObat)
        btnDetail.setOnClickListener {
            val obat_id = obatList[position].id.toString()

            val action = ObatListFragmentDirections.actionItemObatToObatDetailFragment(obat_id)
            Navigation.findNavController(it).navigate(action)
            Log.d("test", obat_id)
        }

        val imageView = holder.view.findViewById<ImageView>(R.id.imgViewObat)
        imageView.loadImage(obatList[position].photoUrl)
    }

    override fun getItemCount(): Int {
        return obatList.size
    }

    fun updateObatList(newObatList: ArrayList<Obat>) {
        obatList.clear()
        obatList.addAll(newObatList)
        notifyDataSetChanged()
    }

}