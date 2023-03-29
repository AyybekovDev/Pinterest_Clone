package com.example.pinterestclone.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pinterestclone.R
import com.example.pinterestclone.model.HomeItem

class PinterestAdapter(val list: ArrayList<HomeItem>) :
    RecyclerView.Adapter<PinterestAdapter.PinterestViewHolder>() {
    var detail: ((String) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinterestViewHolder {
        return PinterestViewHolder(
            (LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false))
        )
    }

    override fun onBindViewHolder(holder: PinterestViewHolder, position: Int) {
        val item = list[position]
        holder.apply {
            Glide.with(ivImage).load(item.urls.small).placeholder(R.drawable.loading).into(ivImage)
            tvLikes.text = item.likes.toString()
            ivImage.setOnClickListener {
                detail?.invoke(item.id)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class PinterestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivImage = view.findViewById<ImageView>(R.id.iv_img)
        val tvLikes = view.findViewById<TextView>(R.id.tv_liked)
    }

    fun submitList(newlist: ArrayList<HomeItem>) {
        list.addAll(newlist)
        notifyDataSetChanged()
    }
}