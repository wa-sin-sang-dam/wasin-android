package com.wasin.data.data_api

import com.wasin.data.model.monitoring.FindAllMonitorRouterResponse
import com.wasin.data.model.monitoring.FindMonitoringByIdResponse
import com.wasin.data.util.ApiUtils

interface MonitoringRepository {
    suspend fun findById(metricId: Long?, routerId: Int, time: Int?): ApiUtils.ApiResult<FindMonitoringByIdResponse>

    suspend fun findAllRouter(): ApiUtils.ApiResult<FindAllMonitorRouterResponse>
}
