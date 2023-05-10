package com.example.a160420043.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420043.R
import com.example.a160420043.viewmodel.JadwalListViewModel
import com.example.a160420043.viewmodel.ObatListViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ObatListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ObatListFragment : Fragment() {
    private lateinit var viewModel:ObatListViewModel
    private val obatListAdapter = ObatListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_obat_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recView = view.findViewById<RecyclerView>(R.id.recViewObat)

        viewModel = ViewModelProvider(this).get(ObatListViewModel::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = obatListAdapter

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.obatsLD.observe(viewLifecycleOwner, Observer {
            obatListAdapter.updateObatList(it)
        })
    }
}