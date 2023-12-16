package com.example.baltleasing.destinations.ServicesScreen.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.baltleasing.R
import com.example.baltleasing.data.ServiceDataModel
import com.example.baltleasing.databinding.LongBlockBinding
import com.example.baltleasing.databinding.SmallBlockBinding
import com.example.baltleasing.databinding.SquareBlockBinding

class FullWidthViewHolder(binding: LongBlockBinding): ServiceViewHolder<LongBlockBinding>(binding) {
    override fun configure(data: ServiceDataModel) {
        binding.mainTextView.text = data.mainText
        binding.subText.text = data.subText
        binding.imageViewLong.setImageResource(data.image.toInt())
    }
}

class HalfWidthSquareViewHolder(binding: SquareBlockBinding): ServiceViewHolder<SquareBlockBinding>(binding) {
    override fun configure(data: ServiceDataModel) {
        binding.mainText.text = data.mainText
        binding.subSquareText.text = data.subText
        binding.squareImage.setImageResource(data.image.toInt())
    }

}

class HalfWidthRectangleViewHolder(binding: SmallBlockBinding): ServiceViewHolder<SmallBlockBinding>(binding) {
    override fun configure(data: ServiceDataModel) {
        binding.textView.text = data.mainText
        if (data.image.isNotEmpty()) {
            binding.smallImageView.setImageResource(data.image.toInt())
        }

    }
}

abstract class ServiceViewHolder<T: ViewBinding>(val binding: T): RecyclerView.ViewHolder(binding.root) {
    abstract fun configure(data: ServiceDataModel)
}