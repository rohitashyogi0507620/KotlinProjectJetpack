package com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.Models

sealed class APIResponse<T>(val data:T? =null, val errrormessage:String?=null) {
    class Loading<T>:APIResponse<T>()
    class Success<T>(data: T?=null):APIResponse<T>(data=data)
    class Error<T>(message: String?):APIResponse<T>(errrormessage = message)
}