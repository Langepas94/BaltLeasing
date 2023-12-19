package com.example.baltleasing.destinations.servicesScreen.adapter

import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.baltleasing.data.ServiceDataModel
import com.example.baltleasing.databinding.LongBlockBinding
import com.example.baltleasing.databinding.SmallBlockBinding
import com.example.baltleasing.databinding.SquareBlockBinding
import com.example.baltleasing.destinations.servicesScreen.view.LongServiceViewHolder
import com.example.baltleasing.destinations.servicesScreen.view.SmallServiceViewHolder
import com.example.baltleasing.destinations.servicesScreen.view.SquareServiceViewHolder
import com.example.baltleasing.destinations.servicesScreen.view.ServiceViewHolder

class ServiceRecyclerAdapter(private val itemList: Array<ServiceDataModel>, private val screen: DisplayMetrics): ListAdapter<ServiceDataModel,ServiceViewHolder<*>>(DiffCallback()) {
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

    private class DiffCallback: DiffUtil.ItemCallback<ServiceDataModel>() {
        override fun areItemsTheSame(oldItem: ServiceDataModel, newItem: ServiceDataModel): Boolean {
            if (oldItem != newItem) return false
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: ServiceDataModel, newItem: ServiceDataModel): Boolean {
            return oldItem == newItem
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

    private fun layoutSetup(holder: ServiceViewHolder<*>): StaggeredGridLayoutManager.LayoutParams {
        val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
        val margins = dpToPx(16f)
        when(holder) {
            is SquareServiceViewHolder -> {
                layoutParams.width = (screen.widthPixels / 2) - margins
                layoutParams.height = (screen.widthPixels / 2)
                return  layoutParams
            }
            is SmallServiceViewHolder -> {
                layoutParams.width = (screen.widthPixels / 2) - margins
                layoutParams.height = (screen.widthPixels / 2) / 2
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

    private fun dpToPx(dp: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, screen).toInt()
    }
}