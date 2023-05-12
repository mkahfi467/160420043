package com.example.a160420043.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160420043.R
import com.example.a160420043.util.loadImage
import com.example.a160420043.viewmodel.JadwalListViewModel
import com.google.android.material.textfield.TextInputEditText

/**
 * A simple [Fragment] subclass.
 * Use the [JadwalPraktikDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class JadwalPraktikDetailFragment : Fragment() {
    private lateinit var viewModel:JadwalListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal_praktik_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jadwalId = JadwalPraktikDetailFragmentArgs.fromBundle(requireArguments()).index

        viewModel = ViewModelProvider(this).get(JadwalListViewModel::class.java)
        viewModel.searchId(jadwalId)

        viewModel.jadwalDetailLD.observe(viewLifecycleOwner, Observer { jadwalDetail ->
            val txtId = view.findViewById<TextInputEditText>(R.id.txtIdJadwalDetail)
            val txtNama = view.findViewById<TextInputEditText>(R.id.txtNamaDokterJadwalDetail)
            val txtHari = view.findViewById<TextInputEditText>(R.id.txtHariJadwalDetail)
            val txtPhotoUrl = view.findViewById<TextInputEditText>(R.id.txtPhotoUrlJadwalDetail)

            txtId.setText(jadwalDetail.id.toString())
            txtNama.setText(jadwalDetail.namaDokter.toString())
            txtHari.setText(jadwalDetail.hari.toString())
            txtPhotoUrl.setText(jadwalDetail.photoUrl.toString())

            val imageView = view.findViewById<ImageView>(R.id.imgViewLayananDetail)
            imageView.loadImage(jadwalDetail.photoUrl)
        })
    }
}