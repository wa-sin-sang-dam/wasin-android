package com.wasin.data.model.monitoring

import kotlinx.serialization.Serializable

@Serializable
data class FindMonitoringByIdResponse (
    val activeMetricId: Long = 0,
    val settingTime: Long = 0,
    val metricList: List<MonitoringMetric> = emptyList(),
    val graphList: List<MonitoringGraph> = emptyList()
) {
    @Serializable
    data class MonitoringMetric(
        val metric: String,
        val metricId: Long
    )

    @Serializable
    data class MonitoringGraph(
        val labels: String,
        val timeList: List<Long>,
        val valueList: List<Long>
    )

}
