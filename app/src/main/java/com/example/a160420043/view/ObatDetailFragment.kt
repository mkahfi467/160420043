package com.example.a160420043.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160420043.R
import com.example.a160420043.util.loadImage
import com.example.a160420043.viewmodel.ObatListViewModel
import com.google.android.material.textfield.TextInputEditText

/**
 * A simple [Fragment] subclass.
 * Use the [ObatDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ObatDetailFragment : Fragment() {
    private lateinit var viewModel: ObatListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_obat_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idObat = ObatDetailFragmentArgs.fromBundle(requireArguments()).obatId
        viewModel = ViewModelProvider(this).get(ObatListViewModel::class.java)
        viewModel.obatDetail(idObat)

        viewModel.obatDetailLD.observe(viewLifecycleOwner, Observer { obatDetail ->
            val txtId = view.findViewById<TextInputEditText>(R.id.txtIdObatDetail)
            val txtNama = view.findViewById<TextInputEditText>(R.id.txtNamaObatDetail)
            val txtKategori = view.findViewById<TextInputEditText>(R.id.txtKategoriObatDetail)

            txtId.setText(obatDetail[0].id.toString())
            txtNama.setText(obatDetail[0].name.toString())
            txtKategori.setText(obatDetail[0].kategori.toString())

            val imageView = view.findViewById<ImageView>(R.id.imgViewObatDetail)
            imageView.loadImage(obatDetail[0].photoUrl)
        })

        // VERSION 2
//        viewModel.obatDetailLD.observe(viewLifecycleOwner, Observer {  ->
//            val txtID = view.findViewById<TextInputEditText>(R.id.txtID)
//            txtID.setText(student.id.toString())
//
//
//            val txtName = view.findViewById<TextInputEditText>(R.id.txtName)
//            txtName.setText(student.name.toString())
//
//            val txtBod = view.findViewById<TextInputEditText>(R.id.txtBod)
//            txtBod.setText(student.dob.toString())
//
//            val txtPhone = view.findViewById<TextInputEditText>(R.id.txtPhone)
//            txtPhone.setText(student.phone.toString())
////            Log.d("TEST", student.name.toString())
//
//            // WEEK 6 CLASS Exercise
//            var imageView = view.findViewById<ImageView>(R.id.imageView2)
//            var progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
//            imageView.loadImage(student.photoUrl.toString(), progressBar)
//        })
    }
}