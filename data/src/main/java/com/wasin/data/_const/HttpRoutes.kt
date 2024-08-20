package com.wasin.data._const


enum class HttpRoutes(
    val path: String
) {
    BASE_HOST("192.168.219.110"),
    BASE_V1_PATH("api/"),

    // user
    SIGN_UP("user/signup"),
    LOGIN("user/login"),
    LOGOUT("user/logout"),
    WITHDRAW("user/withdraw"),
    LOCK("user/lock"),
    LOCK_CONFIRM("user/lock/confirm"),
    EMAIL_CODE_CONFIRM("user/auth/email/check"),
    EMAIL_CODE_SEND("user/auth/email"),
    REISSUE("user/auth/reissue"),

    // company
    GET_OPEN_API("company/open-api/list"),
    GET_DB("company/db"),
    SAVE_COMPANY_OPEN_API("company/open-api"),
    SAVE_COMPANY_DB("company/db"),

    // backoffice
    BACKOFFICE_ACCEPT("backoffice/accept"),
    GET_WAITING_LIST("backoffice"),

    // router
    ROUTER("router"),
    ROUTER_MONITORING("router/monitoring"),
    GET_COMPANY_IMAGE("router/image"),
    DELETE_ROUTER("router/delete"),

    // profile
    GET_PROFILE("profile"),
    PROFILE_MODE_AUTO_CHANGE("profile/mode/auto"),
    PROFILE_MODE_MANUAL_CHANGE("profile/mode/manual"),
    UPDATE_PROFILE("profile"),
    ;

    fun getPath1(): String {
        return "v1/" + this.path
    }
}
