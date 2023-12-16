package com.example.baltleasing.destinations.ServicesScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.baltleasing.data.ServiceDataModel
import com.example.baltleasing.databinding.LongBlockBinding
import com.example.baltleasing.databinding.SmallBlockBinding
import com.example.baltleasing.databinding.SquareBlockBinding
import com.example.baltleasing.destinations.ServicesScreen.view.FullWidthViewHolder
import com.example.baltleasing.destinations.ServicesScreen.view.HalfWidthRectangleViewHolder
import com.example.baltleasing.destinations.ServicesScreen.view.HalfWidthSquareViewHolder
import com.example.baltleasing.destinations.ServicesScreen.view.ServiceViewHolder

class ServiceRecyclerAdapter(private val itemList: Array<ServiceDataModel>): RecyclerView.Adapter<ServiceViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder<*> {
        return when (viewType) {
            0 -> FullWidthViewHolder(
                LongBlockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            1 -> HalfWidthSquareViewHolder(
                SquareBlockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            2 -> HalfWidthRectangleViewHolder(
                SmallBlockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalArgumentException("View type not found")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].type
    }
    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ServiceViewHolder<*>, position: Int) {
        val data = itemList[position]

        when(holder) {
           is FullWidthViewHolder -> {
               val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
               layoutParams.isFullSpan = true
               holder.itemView.layoutParams = layoutParams
               holder.configure(data)
           }
            is HalfWidthSquareViewHolder -> holder.configure(data)
            is HalfWidthRectangleViewHolder -> holder.configure(data)
        }
    }

}