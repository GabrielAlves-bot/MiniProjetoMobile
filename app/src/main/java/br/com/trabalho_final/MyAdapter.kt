package br.com.trabalho_final

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var mCtx: Context, var resources: Int, var items: List<Imovel>): ArrayAdapter<Imovel>(mCtx, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resources, null)

        val imageView: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)
        val price: TextView = view.findViewById(R.id.price)
        val info1: TextView = view.findViewById(R.id.info1)

        var mItem: Imovel = items[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))
        title.text = mItem.descricao
        price.text = mItem.preco.toString()
        info1.text = mItem.cidade
        return view
    }
}