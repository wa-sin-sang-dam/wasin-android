package com.wasin.data.model.monitoring

import kotlinx.serialization.Serializable

@Serializable
data class FindAllMonitorRouterResponse(
    val routerList: List<MonitorRouter> = emptyList()
) {
    @Serializable
    data class MonitorRouter(
        val routerId: Long = 0,
        val name: String = "",
        val instance: String = ""
    ) {
    }

}
