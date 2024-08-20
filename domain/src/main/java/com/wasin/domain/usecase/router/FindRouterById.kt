package com.wasin.domain.usecase.router

import com.wasin.data.data_api.RouterRepository
import com.wasin.data.model.router.FindByRouterIdResponse
import com.wasin.data.util.getErrorMessage
import com.wasin.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FindRouterById @Inject constructor(
    private val routerRepository: RouterRepository
) {
    operator fun invoke(routerId: Long): Flow<Resource<FindByRouterIdResponse>> = flow {
        try {
            emit(Resource.Loading())
            val result = routerRepository.findByRouterId(routerId)
            val success = result.response ?: FindByRouterIdResponse()
            val errorMessage = result.error?.message ?: "라우터를 불러오는데 실패하였습니다."

            if (result.success) emit(Resource.Success(success))
            else emit(Resource.Error(errorMessage))

        } catch(error: Exception){
            emit(Resource.Error(getErrorMessage(error)))
        }
    }
}
