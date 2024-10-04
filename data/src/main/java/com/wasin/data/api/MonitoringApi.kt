package com.wasin.data.api

import com.wasin.data._const.HttpRoutes
import com.wasin.data.data_api.MonitoringRepository
import com.wasin.data.model.monitoring.FindAllMonitorRouterResponse
import com.wasin.data.model.monitoring.FindMonitoringByIdResponse
import com.wasin.data.util.ApiUtils
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MonitoringApi (
    private val client: HttpClient
): MonitoringRepository {
    override suspend fun findById(metricId: Long?, routerId: Int, time: Int?): ApiUtils.ApiResult<FindMonitoringByIdResponse> {
        var path = HttpRoutes.MONITORING.getPath1() + "?routerId=$routerId"
        if (metricId != null) path += "&metricId=$metricId"
        if (time != null) path += "&time=$time"

        return client.get(path).body()
    }

    override suspend fun findAllRouter(): ApiUtils.ApiResult<FindAllMonitorRouterResponse> {
        return client.get(HttpRoutes.MONITORING_ROUTER.getPath1()).body()
    }
}
