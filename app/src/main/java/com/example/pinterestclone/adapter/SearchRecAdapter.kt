package com.example.pinterestclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pinterestclone.R
import com.example.pinterestclone.model.SearchRecModelim


class SearchRecAdapter(val list: ArrayList<SearchRecModelim>) :
    RecyclerView.Adapter<SearchRecAdapter.SearchViewHolder>() {
    var yuborish:((String) -> Unit)?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size

    }
    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = list[position]
        holder.apply {
            Glide.with(ivImage).load(item.imgae).into(ivImage)
            tvText.text=item.text
            fRec.setOnClickListener {
                yuborish?.invoke(item.text)
            }
        }
    }

    class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fRec=view.findViewById<FrameLayout>(R.id.f_search_rec)
        val ivImage = view.findViewById<ImageView>(R.id.image)
        val tvText = view.findViewById<TextView>(R.id.text)
    }

}