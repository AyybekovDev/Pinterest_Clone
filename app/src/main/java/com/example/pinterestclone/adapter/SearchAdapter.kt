package com.example.pinterestclone.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pinterestclone.R
import com.example.pinterestclone.model.search.yangisi.ResultsItem

class SearchAdapter(val list: ArrayList<ResultsItem>) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    var detail: ((String) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            (LayoutInflater.from(parent.context).inflate(R.layout.item_mainsearch, parent, false))
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = list[position]
        holder.apply {
            Glide.with(ivImage).load(item.urls?.thumb).placeholder(R.drawable.loading).into(ivImage)
            tvLikes.text=item.description
            ivImage.setOnClickListener {
                detail?.invoke(item.id!!)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivImage = view.findViewById<ImageView>(R.id.iv_img)
        val tvLikes = view.findViewById<TextView>(R.id.tv_liked123)
    }

    fun submitList(newlist: ArrayList<ResultsItem>) {
        list.addAll(newlist)
        notifyDataSetChanged()
    }
}