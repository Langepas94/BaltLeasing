package com.example.baltleasing.data

import com.example.baltleasing.R

enum class ServiceViewTypes {
    
}

data class ServiceDataModel(
    val mainText: String,
    val subText: String = "",
    val image: String = "",
    val type: Int
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

