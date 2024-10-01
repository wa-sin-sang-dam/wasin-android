package com.wasin.presentation.monitoring

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wasin.data.model.monitoring.FindMonitoringByIdResponse
import com.wasin.domain.usecase.monitoring.FindMonitoringByRouterId
import com.wasin.domain.utils.Resource
import com.wasin.presentation._util.WasinEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MonitoringViewModel @Inject constructor(
    private val findMonitoringByRouterId: FindMonitoringByRouterId
): ViewModel() {

    val selectedTabIndex = mutableStateOf(0)

    private val _monitoring = mutableStateOf(MonitoringState())
    val monitoring = _monitoring

    private val _eventFlow = MutableSharedFlow<WasinEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        findMonitoring(null)
    }

    fun onTabClick(tabIndex: Int, metricId: Long?) {
        if (selectedTabIndex.value != tabIndex){
            Log.d("wasin_log", "tab: $tabIndex metric: $metricId selected ${selectedTabIndex.value}")
            selectedTabIndex.value = tabIndex
            findMonitoring(metricId)
        }
    }

    private fun findMonitoring(metricId: Long?) {
        findMonitoringByRouterId(metricId, 1, null).onEach { response ->
            _monitoring.value = _monitoring.value.copy(
                metrics = response.data ?: FindMonitoringByIdResponse(),
                isLoading = response is Resource.Loading,
                errorMessage = if (response is Resource.Error) response.message else ""
            )
            Log.d("wasin_log", monitoring.value.toString())
        }.launchIn(viewModelScope)

    }

}
