package com.skilled.obstest.auth

import com.skilled.obstest.data.User

/**
 * @created 10.12.2022
 * @author SkilledLis
 */
interface Authentication {
    fun auth(user: User?)
}
