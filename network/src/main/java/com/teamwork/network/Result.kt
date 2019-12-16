package com.teamwork.network

sealed class Result<out T : Any, out Z : Any> {
    data class Success<out T : Any, out Z : Any>(val data: T) : Result<T, Z>()
    data class Error<out T : Any, out Z : Any>(val exception: Z) : Result<T, Z>()
}