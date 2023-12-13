package com.example.baltleasing.data

import com.example.baltleasing.R

data class ServiceDataModel(
    val mainText: String,
    val subText: String = "",
    val image: String = ""
)

data class ServiceScreenModel (
    val strah: ServiceDataModel,
    val sputnik: ServiceDataModel,
    val ugon: ServiceDataModel,
    val garant: ServiceDataModel,
    val toplivo: ServiceDataModel,
    val helpCards: ServiceDataModel,
    val monitoring: ServiceDataModel,
    val dostavka: ServiceDataModel,
    val shinka: ServiceDataModel,
    val sodeistvie: ServiceDataModel
)

class MockServicesScreen {

    companion object {
        private val getImageStrah = R.drawable.glass.toString()
        private val strah = ServiceDataModel( mainText = "Страхование", subText = "Выгодные условия по страхованию. Спецтарифы на оформление КАСКО будут доступны вам и после окончания срока договора лизинга", image = getImageStrah)
//
        private val getImageSputnik = R.drawable.lock.toString()
        private val sputnik = ServiceDataModel( mainText = "Спутниковые противоугонные системы", subText = "Контур дополнительной охраны", image = getImageSputnik)

        private val getImageGarant = R.drawable.lock.toString()
        private val garant = ServiceDataModel( mainText = "Спутниковые противоугонные системы", subText = "Контур дополнительной охраны", image = getImageGarant)

        private val getImageToplivo = R.drawable.greencards.toString()
        private val toplivo = ServiceDataModel( mainText = "Спутниковые противоугонные системы", subText = "Контур дополнительной охраны", image = getImageToplivo)

        private val getImageHelp = R.drawable.bluecards.toString()
        private val helpCards = ServiceDataModel( mainText = "Спутниковые противоугонные системы", subText = "Контур дополнительной охраны", image = getImageHelp)

        private val monitoring = ServiceDataModel( mainText = "Спутниковые противоугонные системы", subText = "Контур дополнительной охраны")

        private val getImageDostavka = R.drawable.locations.toString()
        private val dostavka = ServiceDataModel( mainText = "Спутниковые противоугонные системы", subText = "Контур дополнительной охраны", image = getImageDostavka)

        private val getImageShinka = R.drawable.bluewheel.toString()
        private val shinka = ServiceDataModel( mainText = "Спутниковые противоугонные системы", subText = "Контур дополнительной охраны", image = getImageShinka)

        private val getImageSodeistvie = R.drawable.document.toString()
        private val sodeistvie = ServiceDataModel( mainText = "Спутниковые противоугонные системы", subText = "Контур дополнительной охраны", image = getImageSodeistvie)

        val model = ServiceScreenModel(
            strah = strah,
            sputnik = sputnik,
            dostavka = dostavka,
            ugon = sputnik,
            garant = garant,
            helpCards = helpCards,
            monitoring = monitoring,
            shinka = shinka,
            sodeistvie = sodeistvie,
            toplivo = toplivo
        )
    }
}