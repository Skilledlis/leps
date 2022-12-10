package com.skilled.obstest.data


/**
 * @created 10.12.2022
 * @author SkilledLis
 */
interface Repository {

    suspend fun auth(user: User): TokenResponse

    class MockRepository : Repository {
        override suspend fun  auth(user: User): TokenResponse {
            return TokenResponse.Error("Unauthorized")
        }
    }

}
