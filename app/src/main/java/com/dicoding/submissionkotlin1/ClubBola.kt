package com.dicoding.submissionkotlin1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class ClubBola(val items: List<ItemData>, val listener: (ItemData) -> Unit) : RecyclerView.Adapter<ClubBola.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ClubView().createView(AnkoContext.Companion.create(parent.context, parent)))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        val image = itemView.findViewById<ImageView>(ClubView.club_image)
        val name = itemView.findViewById<TextView>(ClubView.club_name)

        fun bind(item: ItemData, listener: (ItemData) -> Unit) {
            Glide.with(itemView.context)
                    .load(item.image)
                    .into(image)

            name.text = item.name

            itemView.setOnClickListener { listener(item) }
        }
    }
}