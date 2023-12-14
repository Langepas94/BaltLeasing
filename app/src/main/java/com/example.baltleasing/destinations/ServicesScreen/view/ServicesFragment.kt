package com.example.baltleasing

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.baltleasing.data.ServiceScreenModel
import com.example.baltleasing.databinding.FragmentServicesBinding
import com.example.baltleasing.destinations.ServicesScreen.viewModel.ServicesViewModel

class ServicesFragment : Fragment() {

    private val viewModel: ServicesViewModel by activityViewModels()

    private lateinit var binding: FragmentServicesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentServicesBinding.inflate(layoutInflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       viewModelBind()
        viewModel.getData()
    }

    private fun viewModelBind() {

        viewModel.data.observe(activity as LifecycleOwner) {
            binding.longStrahBlock.mainTextView.text = it.strah.mainText
            binding.longStrahBlock.subText.text = it.strah.subText
            binding.longStrahBlock.imageViewLong.setImageResource(it.strah.image.toInt())

            binding.squareSputnikBLock.mainText.text = it.sputnik.mainText
            binding.squareSputnikBLock.subSquareText.text = it.sputnik.subText
            binding.squareSputnikBLock.squareImage.setImageResource(it.sputnik.image.toInt())

            binding.guaranteeSmall.textView.text = it.garant.mainText
            binding.guaranteeSmall.smallImageView.setImageResource(it.garant.image.toInt())
            changeGravityForGuarantee()

            binding.fuelProgramsSmall.textView.text = it.toplivo.mainText
            binding.fuelProgramsSmall.smallImageView.setImageResource(it.toplivo.image.toInt())

            binding.mapsLongBlock.mainTextView.text = it.helpCards.mainText
            binding.mapsLongBlock.subText.text = it.helpCards.subText
            binding.mapsLongBlock.imageViewLong.setImageResource(it.helpCards.image.toInt())

            binding.monitoringSmall.textView.text = it.monitoring.mainText

            binding.wheelsSmall.textView.text = it.shinka.mainText
            binding.wheelsSmall.smallImageView.setImageResource(it.shinka.image.toInt())

            binding.squareShippingBlock.mainText.text = it.dostavka.mainText
            binding.squareShippingBlock.squareImage.setImageResource(it.dostavka.image.toInt())

            binding.sodeistvieLongBlock.mainTextView.text = it.sodeistvie.mainText
            binding.sodeistvieLongBlock.imageViewLong.setImageResource(it.sodeistvie.image.toInt())
        }
    }

    // колхоз, но там картинка обрезана снизу и всего в одном месте из всех подобных ячеек картинка должна быть внизу, вышел так из положения
    private fun changeGravityForGuarantee() {
        val image = binding.guaranteeSmall.smallImageView
        val params = image.layoutParams as LinearLayout.LayoutParams
        params.gravity = Gravity.BOTTOM
        image.layoutParams = params
    }
}