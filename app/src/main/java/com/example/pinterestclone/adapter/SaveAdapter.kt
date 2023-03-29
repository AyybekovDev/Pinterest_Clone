package com.example.pinterestclone.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pinterestclone.R
import com.example.pinterestclone.model.search.OnePeople

class SaveAdapter(val list: ArrayList<OnePeople>) :
    RecyclerView.Adapter<SaveAdapter.SaveViewHolder>() {
    var detail:((String)->Unit)?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaveViewHolder {
        return SaveViewHolder(
            (LayoutInflater.from(parent.context).inflate(R.layout.item_save, parent, false))
        )
    }

    override fun onBindViewHolder(holder: SaveViewHolder, position: Int) {
        val item = list[position]
        holder.apply {
            tvTitle.text=item.likes.toInt().toString()
            Glide.with(ivImage).load(item.urls.thumb).placeholder(R.drawable.loading).into(ivImage)
            ivImage.setOnClickListener {
                detail?.invoke(item.id)
            }
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }
    class SaveViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivImage = view.findViewById<ImageView>(R.id.iv_Simg)
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
    }
    fun submitList(newlist: OnePeople) {
        list.addAll(listOf(newlist))
        notifyDataSetChanged()
    }
}