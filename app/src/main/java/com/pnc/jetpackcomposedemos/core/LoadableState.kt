package com.pnc.jetpackcomposedemos.core

sealed interface LoadableState<out T> { //any data type itself that considered artist loadable state of specialized artist considered state of artist
    data object Loading: LoadableState<Nothing>
    data object Empty: LoadableState<Nothing>
    data class Success<T>(
        val data: T
    ): LoadableState<T>
    data class Error(
        val message: String
    ): LoadableState<Nothing>
}