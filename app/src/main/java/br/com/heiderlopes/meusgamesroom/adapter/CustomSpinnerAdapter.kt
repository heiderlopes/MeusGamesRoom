package br.com.heiderlopes.meusgamesroom.adapter

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SpinnerAdapter
import android.widget.TextView

class CustomSpinnerAdapter<T : ItemCustomSpinner>(
        private val context: Context,
        private val lista: List<T>) : BaseAdapter(), SpinnerAdapter {

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(i: Int): Any {
        return lista[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    fun getMyItemId(position: Int): Any {
        return lista[position].itemID
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val txt = TextView(context)
        txt.setPadding(48, 48, 48, 48)
        txt.textSize = 18f
        txt.gravity = Gravity.CENTER_VERTICAL
        txt.text = lista[position].itemDescription
        txt.setTextColor(Color.parseColor("#000000"))
        return txt
    }

    override fun getView(i: Int, view: View?, viewgroup: ViewGroup): View {
        val txt = TextView(context)
        txt.gravity = Gravity.LEFT
        txt.setPadding(16, 32, 16, 32)
        txt.textSize = 16f
        txt.text = lista[i].itemDescription
        txt.setTextColor(Color.parseColor("#000000"))
        return txt
    }
}