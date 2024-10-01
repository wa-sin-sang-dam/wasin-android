package com.wasin.presentation.monitoring

import com.wasin.data.model.monitoring.FindMonitoringByIdResponse

data class MonitoringState (
    val isLoading: Boolean = true,
    val metrics: FindMonitoringByIdResponse = FindMonitoringByIdResponse(),
    val errorMessage: String = ""
)
