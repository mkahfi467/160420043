package com.example.a160420043.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420043.R
import com.example.a160420043.viewmodel.LayananListViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [LayananListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LayananListFragment : Fragment() {
    private lateinit var viewModel:LayananListViewModel
    private val layananListAdapter = LayananListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layanan_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recView = view.findViewById<RecyclerView>(R.id.recViewLayanan)

        viewModel = ViewModelProvider(this).get(LayananListViewModel::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = layananListAdapter

//        Log.d("TEST", viewModel.layanansLD.value.toString())

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.layanansLD.observe(viewLifecycleOwner, Observer {
            layananListAdapter.updateJadwalList(it)
        })
    }
}