package com.skilled.obstest.data

/**
 * @created 10.12.2022
 * @author SkilledLis
 */
sealed class TokenResponse {
    class Success<T>(val data: T) : TokenResponse()
    class Error(val errorMessage: String) : TokenResponse()
    object Loading : TokenResponse()
    object Empty : TokenResponse()
}