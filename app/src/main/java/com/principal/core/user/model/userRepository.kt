package com.principal.core.user.model

interface userRepository {
    fun create(user: user?): Boolean
    fun readAll(): Array<user?>?
    fun deleteUser(user: user?):user?
    fun readUser(user: user?):Array<user?>?

}