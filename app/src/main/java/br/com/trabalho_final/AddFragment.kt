package br.com.trabalho_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.trabalho_final.room.Viagem
import br.com.trabalho_final.room.ViagemViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mUserViewModel: ViagemViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        mUserViewModel = ViewModelProvider(this).get(ViagemViewModel::class.java)
        view.buttonAdd.setOnClickListener{
            insertDataToDataBase()
            Toast.makeText(requireContext(),"Adicionado com Sucesso",Toast.LENGTH_LONG).show()
            System.out.println("passou")
        }
        return view
    }

    private fun insertDataToDataBase() {
        val cidadeviagem = cidadeviagem.text.toString()
        val descricaoviagem = descricaoviagem.text.toString()
        val tipoviagem = tipoviagem.text.toString()

        val viagem = Viagem(null,cidadeviagem,descricaoviagem,tipoviagem)
        mUserViewModel.addViagem(viagem)
        findNavController().navigate(R.id.action_addFragment_to_listFragment)

    }



}