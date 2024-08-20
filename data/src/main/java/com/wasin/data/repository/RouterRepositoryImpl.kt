package com.wasin.data.repository

import com.wasin.data.api.RouterApi
import com.wasin.data.data_api.RouterRepository
import com.wasin.data.model.router.CreateRouterRequest
import com.wasin.data.model.router.FindAllRouterResponse
import com.wasin.data.model.router.FindByRouterIdResponse
import com.wasin.data.model.router.FindCompanyImageResponse
import com.wasin.data.model.router.UpdateRouterRequest
import com.wasin.data.util.ApiUtils
import javax.inject.Inject

class RouterRepositoryImpl @Inject constructor(
    private val routerApi: RouterApi
): RouterRepository {
    override suspend fun findAll(): ApiUtils.ApiResult<FindAllRouterResponse> {
        return routerApi.findAll()
    }

    override suspend fun findByRouterId(routerId: Long): ApiUtils.ApiResult<FindByRouterIdResponse> {
        return routerApi.findByRouterId(routerId)
    }

    override suspend fun create(request: CreateRouterRequest): ApiUtils.ApiResult<String> {
        return routerApi.create(request)
    }

    override suspend fun update(
        request: UpdateRouterRequest,
        routerId: Long
    ): ApiUtils.ApiResult<String> {
        return routerApi.update(request, routerId)
    }

    override suspend fun delete(routerId: Long): ApiUtils.ApiResult<String> {
        return routerApi.delete(routerId)
    }

    override suspend fun findCompanyImage(): ApiUtils.ApiResult<FindCompanyImageResponse> {
        return routerApi.findCompanyImage()
    }

}
