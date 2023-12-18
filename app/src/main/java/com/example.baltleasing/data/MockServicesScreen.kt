package com.example.baltleasing.data

import com.example.baltleasing.R

class MockServicesScreen {

    companion object {
        private val getImageStrah = R.drawable.glass.toString()
        private val strah = ServiceDataModel( mainText = "Страхование", subText = "Выгодные условия по страхованию. Спецтарифы на оформление КАСКО будут доступны вам и после окончания срока договора лизинга", image = getImageStrah, 0)
        //
        private val getImageSputnik = R.drawable.lock.toString()
        private val sputnik = ServiceDataModel( mainText = "Спутниковые противоугонные системы", subText = "Контур дополнительной охраны", image = getImageSputnik, 1)

        private val getImageGarant = R.drawable.anotherglass.toString()
        private val garant = ServiceDataModel( mainText = "Гарантия на авто", image = getImageGarant, type = 2)

        private val getImageToplivo = R.drawable.greencards.toString()
        private val toplivo = ServiceDataModel( mainText = "Топливные программы", image = getImageToplivo, type = 2)

        private val getImageHelp = R.drawable.bluecards.toString()
        private val helpCards = ServiceDataModel( mainText = "Карты помощи на дорогах", subText = "5 видов карт для всех сегментов авто", image = getImageHelp, 0)

        private val monitoring = ServiceDataModel( mainText = "Мониторинговые системы", type = 2)

        private val getImageDostavka = R.drawable.locations.toString()
        private val dostavka = ServiceDataModel( mainText = "Доставка к месту эксплуатации", image = getImageDostavka, type = 1)

        private val getImageShinka = R.drawable.bluewheel.toString()
        private val shinka = ServiceDataModel( mainText = "Шинный сервис", image = getImageShinka, type = 2)

        private val getImageSodeistvie = R.drawable.document.toString()
        private val sodeistvie = ServiceDataModel( mainText = "Содействие в организации регистрации транспорта и спецтехники", image = getImageSodeistvie, type = 0)

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

        val array = arrayOf(strah, sputnik, garant, toplivo, helpCards, monitoring, dostavka, shinka, sodeistvie)
    }
}