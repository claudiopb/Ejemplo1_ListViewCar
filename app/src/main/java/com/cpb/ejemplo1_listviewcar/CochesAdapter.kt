package com.cpb.ejemplo1_listviewcar

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.cpb.ejemplo1_listviewcar.databinding.MoldeCocheBinding
import com.cpb.ejemplo1_listviewcar.databinding.MoldeVentaBinding

class CochesAdapter(context: Context, var listaDeCoches: ArrayList<coche>) : BaseAdapter() {

    var context: Context? = context

    override fun getCount(): Int {
        return listaDeCoches.size
    }

    override fun getItem(position: Int): Any {
        return listaDeCoches[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var coche = listaDeCoches[position]

        if (coche.venta == true) {

            val inflater =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val miVista = MoldeCocheBinding.inflate(inflater, parent, false)
            val view = miVista.root

            miVista.imageView2.setImageResource(coche.imagen!!)
            miVista.textViewTitulo.text = coche.titulo!!
            miVista.textViewDescripcion.text = coche.descripcion!!
            miVista.textViewPrecio.text = coche.precio!!

            miVista.imageView2.setOnClickListener {
                val intent = Intent(context, CocheActivity::class.java)
                intent.putExtra("Imagen", coche.imagen!!)
                intent.putExtra("Título", coche.titulo!!)
                intent.putExtra("Descripción", coche.descripcion!!)
                intent.putExtra("Precio", coche.precio!!)
                context!!.startActivity(intent)

            }

            return view
        } else {

            val inflater =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val miVista = MoldeVentaBinding.inflate(inflater, parent, false)
            val view = miVista.root

            miVista.imageView2.setImageResource(coche.imagen!!)
            miVista.textViewTitulo.text = coche.titulo!!
            miVista.textViewDescripcion.text = coche.descripcion!!
            miVista.textViewPrecio.text = coche.precio!!

            miVista.imageView2.setOnClickListener {
                val intent = Intent(context, VentaActivity::class.java)
                intent.putExtra("Imagen", coche.imagen!!)
                intent.putExtra("Título", coche.titulo!!)
                intent.putExtra("Descripción", coche.descripcion!!)
                intent.putExtra("Precio", coche.precio!!)
                context!!.startActivity(intent)

            }

            return view

        }

    }


}
