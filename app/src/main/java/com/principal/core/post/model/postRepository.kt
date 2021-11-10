package com.principal.core.post.model

import com.principal.core.user.model.user

interface postRepository {
    fun create(User: user, Post :post) :post
    fun edit(User: user,Post: post) :post
    fun delete(Post: post) 
    fun read(User: user):ArrayList<post>
    fun readAll() : ArrayList<post>
}
