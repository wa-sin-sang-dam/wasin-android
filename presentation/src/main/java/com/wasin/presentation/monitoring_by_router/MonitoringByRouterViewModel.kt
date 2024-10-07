package com.wasin.presentation.monitoring_by_router

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wasin.data.model.monitoring.FindMonitoringByIdResponse
import com.wasin.domain.usecase.monitoring.FindMonitoringByRouterId
import com.wasin.domain.utils.Resource
import com.wasin.presentation._util.WasinEvent
import com.wasin.presentation.monitoring.MonitoringState
import com.wasin.presentation.monitoring.TimeEnum
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MonitoringByRouterViewModel @Inject constructor(
    private val findMonitoringByRouterId: FindMonitoringByRouterId,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val selectedTabIndex = mutableIntStateOf(0)
    val activeTime = mutableStateOf(TimeEnum.THIRTY_MINUTES_AGO)
    private val metricId = mutableStateOf<Long?>(null)
    private val routerId = mutableIntStateOf(-1)

    private val _monitoring = mutableStateOf(MonitoringState())
    val monitoring = _monitoring

    private val _eventFlow = MutableSharedFlow<WasinEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        savedStateHandle.get<Long>("routerId")?.let{
            routerId.intValue = it.toInt()
        }
        findMonitoring()
    }

    fun onTabClick(tabIndex: Int, _metricId: Long?) {
        if (selectedTabIndex.value != tabIndex){
            selectedTabIndex.value = tabIndex
            metricId.value = _metricId
            findMonitoring()
        }
    }

    fun refreshTime(index: Int) {
        activeTime.value = TimeEnum.entries.getOrNull(index) ?: TimeEnum.THIRTY_MINUTES_AGO
        findMonitoring()
    }

    fun refreshMetric() {
        findMonitoring()
    }

    private fun findMonitoring() {
        findMonitoringByRouterId(
            metricId.value,
            routerId.intValue,
            activeTime.value.time
        ).onEach { response ->
            _monitoring.value = _monitoring.value.copy(
                metrics = response.data ?: FindMonitoringByIdResponse(),
                isLoading = response is Resource.Loading,
                errorMessage = if (response is Resource.Error) response.message else ""
            )
        }.launchIn(viewModelScope)
    }


}
