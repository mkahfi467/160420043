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
import com.example.a160420043.viewmodel.LayananListViewModel
import com.google.android.material.textfield.TextInputEditText

/**
 * A simple [Fragment] subclass.
 * Use the [LayananListDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LayananListDetailFragment : Fragment() {
    private lateinit var viewModel:LayananListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layanan_list_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = LayananListDetailFragmentArgs.fromBundle(requireArguments()).id

        viewModel = ViewModelProvider(this).get(LayananListViewModel::class.java)
        viewModel.searchId(id)

        viewModel.layananDetailLD.observe(viewLifecycleOwner, Observer { layananDetail ->
            val txtId = view.findViewById<TextInputEditText>(R.id.txtIdLayananDetail)
            val txtNama = view.findViewById<TextInputEditText>(R.id.txtNamaLayananDetail)
            val txtKeterangan = view.findViewById<TextInputEditText>(R.id.txtKeteranganLayananDetail)
            val txtPhotoUrl = view.findViewById<TextInputEditText>(R.id.txtPhotoUrlLayananDetail)

            txtId.setText(layananDetail.id.toString())
            txtNama.setText(layananDetail.nama.toString())
            txtKeterangan.setText(layananDetail.keterangan.toString())
            txtPhotoUrl.setText(layananDetail.photoUrl.toString())

            val imageView = view.findViewById<ImageView>(R.id.imgViewLayananDetail)
            imageView.loadImage(layananDetail.photoUrl)
        })
    }
}