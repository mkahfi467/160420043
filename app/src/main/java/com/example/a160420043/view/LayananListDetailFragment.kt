package com.example.a160420043.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a160420043.R
/**
 * A simple [Fragment] subclass.
 * Use the [LayananListDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LayananListDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layanan_list_detail, container, false)
    }
}