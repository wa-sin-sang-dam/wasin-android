package com.wasin.data.api

import com.wasin.data._const.HttpRoutes
import com.wasin.data.data_api.RouterRepository
import com.wasin.data.model.router.CreateRouterRequest
import com.wasin.data.model.router.FindAllRouterResponse
import com.wasin.data.model.router.FindByRouterIdResponse
import com.wasin.data.model.router.FindCompanyImageResponse
import com.wasin.data.model.router.UpdateRouterRequest
import com.wasin.data.util.ApiUtils
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody

class RouterApi (
    private val client: HttpClient
): RouterRepository {
    override suspend fun findAll(): ApiUtils.ApiResult<FindAllRouterResponse> {
        return client.get(HttpRoutes.ROUTER.getPath1()).body()
    }

    override suspend fun findByRouterId(routerId: Long): ApiUtils.ApiResult<FindByRouterIdResponse> {
        return client.get(HttpRoutes.ROUTER.getPath1() + "/$routerId").body()
    }

    override suspend fun create(request: CreateRouterRequest): ApiUtils.ApiResult<String> {
        return client.post(HttpRoutes.ROUTER.getPath1()) {
            setBody(request)
        }.body()
    }

    override suspend fun update(
        request: UpdateRouterRequest,
        routerId: Long
    ): ApiUtils.ApiResult<String> {
        return client.put(HttpRoutes.ROUTER.getPath1() + "/$routerId") {
            setBody(request)
        }.body()
    }

    override suspend fun delete(routerId: Long): ApiUtils.ApiResult<String> {
        return client.post(HttpRoutes.DELETE_ROUTER.getPath1() + "/$routerId").body()
    }

    override suspend fun findCompanyImage(): ApiUtils.ApiResult<FindCompanyImageResponse> {
        return client.get(HttpRoutes.GET_COMPANY_IMAGE.getPath1()).body()
    }

}
