package com.wasin.data.util

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.serialization.SerializationException
import java.io.IOException
import java.util.concurrent.TimeoutException

fun getErrorMessage(e: Exception): String{
    return when (e){
        is RedirectResponseException -> "리다렉션 에러가 발생했습니다."
        is ClientRequestException -> "요청한 내용이 올바르지 않습니다."
        is ServerResponseException -> "서버에 문제가 생겼습니다."
        is TimeoutException -> "네트워크 상황을 확인해주세요."
        is IOException -> "서버 연결 오류가 발생했습니다."
        is SerializationException -> "데이터 처리 중 오류가 발생했습니다."
        else -> "에러가 발생했습니다.\n다시 시도해주세요."
    }
}
