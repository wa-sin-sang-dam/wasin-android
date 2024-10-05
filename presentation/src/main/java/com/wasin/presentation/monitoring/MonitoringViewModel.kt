package com.wasin.presentation.monitoring

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wasin.data.model.monitoring.FindAllMonitorRouterResponse
import com.wasin.data.model.monitoring.FindMonitoringByIdResponse
import com.wasin.domain.usecase.monitoring.FindAllMonitoringRouter
import com.wasin.domain.usecase.monitoring.FindMonitoringByRouterId
import com.wasin.domain.utils.Resource
import com.wasin.presentation._util.WasinEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MonitoringViewModel @Inject constructor(
    private val findMonitoringByRouterId: FindMonitoringByRouterId,
    private val findAllMonitoringRouter: FindAllMonitoringRouter,
): ViewModel() {

    val selectedTabIndex = mutableStateOf(0)
    val activeTime = mutableStateOf(TimeEnum.THIRTY_MINUTES_AGO)
    val activeRouter = mutableStateOf(FindAllMonitorRouterResponse.MonitorRouter())
    private val metricId = mutableStateOf<Long?>(null)

    private val _monitoring = mutableStateOf(MonitoringState())
    val monitoring = _monitoring

    private val _routers = mutableStateOf(FindAllMonitorRouterResponse())
    val routers = _routers

    private val _eventFlow = MutableSharedFlow<WasinEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        initMonitoringData()
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

    fun refreshRouter(index: Int) {
        activeRouter.value = routers.value.routerList.getOrNull(index)
            ?: FindAllMonitorRouterResponse.MonitorRouter()
        findMonitoring()
    }

    private fun initMonitoringData() {
        viewModelScope.launch {
            findAllMonitoringRouter().collect { response ->
                when (response) {
                    is Resource.Loading ->  _eventFlow.emit(WasinEvent.Loading)
                    is Resource.Error -> _eventFlow.emit(WasinEvent.MakeToast(response.message))
                    is Resource.Success -> {
                        _routers.value = _routers.value.copy(
                            response.data?.routerList ?: emptyList()
                        )
                        activeRouter.value = routers.value.routerList.getOrNull(0)
                            ?: FindAllMonitorRouterResponse.MonitorRouter()
                        findMonitoring()
                    }
                }
            }
        }
    }

    private fun findMonitoring() {
        findMonitoringByRouterId(
            metricId.value,
            activeRouter.value.routerId.toInt(),
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
