package com.wasin.data.model.handoff

import kotlinx.serialization.Serializable

@Serializable
data class FindBestHandOffResponse(
    val isAuto: Boolean = false,
    val routerList: List<RouterWithStateDTO> = emptyList()
) {
    @Serializable
    data class RouterWithStateDTO(
        val level: Long,
        val score: Long,
        val ssid: String,
        val macAddress: String,
        val password: String,
        val isSystemExist: Boolean
    )
}
