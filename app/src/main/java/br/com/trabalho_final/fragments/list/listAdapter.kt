package br.com.trabalho_final.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.trabalho_final.R
import br.com.trabalho_final.room.Viagem
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var viagemList = emptyList<Viagem>()
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = viagemList[position]
        holder.itemView.cidadeViagem.text= currentItem.cidadeViagem
        holder.itemView.textViewdescricaoViagem.text=currentItem.descricaoViagem
        holder.itemView.textViewtipoViagem.text=currentItem.tipoViagem
    }

    override fun getItemCount(): Int {
        return viagemList.size.toInt()

    }

    fun setData(viagem: List<Viagem>){
        this.viagemList=viagem
        notifyDataSetChanged()
    }
}