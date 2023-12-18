package com.example.baltleasing.destinations.ServicesScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.baltleasing.data.ServiceDataModel
import com.example.baltleasing.databinding.LongBlockBinding
import com.example.baltleasing.databinding.SmallBlockBinding
import com.example.baltleasing.databinding.SquareBlockBinding
import com.example.baltleasing.destinations.ServicesScreen.view.LongServiceViewHolder
import com.example.baltleasing.destinations.ServicesScreen.view.SmallServiceViewHolder
import com.example.baltleasing.destinations.ServicesScreen.view.SquareServiceViewHolder
import com.example.baltleasing.destinations.ServicesScreen.view.ServiceViewHolder

class ServiceRecyclerAdapter(private val itemList: Array<ServiceDataModel>, private val screenWidth: Int): RecyclerView.Adapter<ServiceViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder<*> {
        return when (viewType) {
            0 -> LongServiceViewHolder(
                LongBlockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            1 -> SquareServiceViewHolder(
                SquareBlockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            2 -> SmallServiceViewHolder(
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
           is LongServiceViewHolder -> {
               holder.itemView.layoutParams = layoutSetup(holder)
               holder.configure(data)
           }
            is SquareServiceViewHolder -> {
                holder.itemView.layoutParams = layoutSetup(holder)
                holder.configure(data)
            }
            is SmallServiceViewHolder -> {
                holder.itemView.layoutParams =  layoutSetup(holder)
               holder.configure(data)
            }
        }
    }

    fun layoutSetup(holder: ServiceViewHolder<*>): StaggeredGridLayoutManager.LayoutParams {
        val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
        val margins = 32
        val betweenMargin = 12
        when(holder) {
            is SquareServiceViewHolder -> {
                layoutParams.width = (screenWidth / 2) - margins - betweenMargin
                layoutParams.height = (layoutParams.width)
                return  layoutParams
            }
            is SmallServiceViewHolder -> {
                layoutParams.width = (screenWidth / 2) - margins - betweenMargin
                layoutParams.height = (layoutParams.width / 2)
                return  layoutParams
            }
            is LongServiceViewHolder -> {
                layoutParams.isFullSpan = true
                return  layoutParams
            }
            else -> {
                layoutParams.isFullSpan = true
                return layoutParams
            }
        }
    }
}