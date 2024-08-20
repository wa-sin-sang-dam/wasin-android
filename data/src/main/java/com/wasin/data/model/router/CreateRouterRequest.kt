package com.wasin.data.model.router

import kotlinx.serialization.Serializable

@Serializable
data class CreateRouterRequest(
    val name: String = "",
    val macAddress: String = "",
    val positionX: Double = 0.0,
    val positionY: Double = 0.0
)
