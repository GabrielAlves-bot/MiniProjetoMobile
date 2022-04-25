package br.com.trabalho_final.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.trabalho_final.R
import br.com.trabalho_final.room.ViagemViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class listFragment : Fragment() {
    private lateinit var mViagemViewModel:ViagemViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_list, container, false)

        //recyclerview
        val adapter=ListAdapter()
        val recyclerview= view.recyclerViewList
        recyclerview.adapter=adapter
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        mViagemViewModel = ViewModelProvider(this).get(ViagemViewModel::class.java)
        mViagemViewModel.filterViagem.observe(viewLifecycleOwner, Observer {viagem ->
            adapter.setData(viagem)
        })
        view.floatingActionButton.setOnClickListener {
             findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }

}