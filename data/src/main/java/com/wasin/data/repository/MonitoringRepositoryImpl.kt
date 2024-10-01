package com.wasin.data.repository

import com.wasin.data.api.MonitoringApi
import com.wasin.data.data_api.MonitoringRepository
import com.wasin.data.model.monitoring.FindMonitoringByIdResponse
import com.wasin.data.util.ApiUtils
import javax.inject.Inject

class MonitoringRepositoryImpl @Inject constructor(
    private val monitoringApi: MonitoringApi
): MonitoringRepository {
    override suspend fun findById(
        metricId: Long?,
        routerId: Int,
        time: Int?
    ): ApiUtils.ApiResult<FindMonitoringByIdResponse> {
        return monitoringApi.findById(metricId, routerId, time)
    }
}
