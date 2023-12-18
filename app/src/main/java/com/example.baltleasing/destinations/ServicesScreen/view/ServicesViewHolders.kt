package com.example.baltleasing.destinations.ServicesScreen.view

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.baltleasing.data.ServiceDataModel
import com.example.baltleasing.databinding.LongBlockBinding
import com.example.baltleasing.databinding.SmallBlockBinding
import com.example.baltleasing.databinding.SquareBlockBinding

abstract class ServiceViewHolder<T: ViewBinding>(val binding: T): RecyclerView.ViewHolder(binding.root) {
    abstract fun configure(data: ServiceDataModel)
}

class LongServiceViewHolder(binding: LongBlockBinding): ServiceViewHolder<LongBlockBinding>(binding) {
    override fun configure(data: ServiceDataModel) {
        binding.mainTextView.text = data.mainText
        binding.subText.text = data.subText
        binding.imageViewLong.setImageResource(data.image.toInt())
    }
}

class SquareServiceViewHolder(binding: SquareBlockBinding): ServiceViewHolder<SquareBlockBinding>(binding) {
    override fun configure(data: ServiceDataModel) {
        binding.mainText.text = data.mainText
        binding.subSquareText.text = data.subText
        binding.squareImage.setImageResource(data.image.toInt())
    }
}

class SmallServiceViewHolder(binding: SmallBlockBinding): ServiceViewHolder<SmallBlockBinding>(binding) {
    override fun configure(data: ServiceDataModel) {
        binding.textView.text = data.mainText
        if (data.image.isNotEmpty()) {
            binding.smallImageView.setImageResource(data.image.toInt())
        }
    }

}

