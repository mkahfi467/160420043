package com.example.a160420043.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420043.R
import com.example.a160420043.viewmodel.JadwalListViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [JadwalPraktikListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class JadwalPraktikListFragment : Fragment() {
    private lateinit var viewModel:JadwalListViewModel
    private val jadwalListAdapter = JadwalDokterListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal_praktik_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recView = view.findViewById<RecyclerView>(R.id.recViewJadwal)

        viewModel = ViewModelProvider(this).get(JadwalListViewModel::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = jadwalListAdapter

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.jadwalsLD.observe(viewLifecycleOwner, Observer {
            jadwalListAdapter.updateJadwalList(it)
        })
    }

}