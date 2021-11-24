package com.principal.core.post.application

import com.principal.core.post.infraestructure.postFirestoreRepository
import com.principal.core.post.model.post
import com.principal.core.user.model.user

class ReadAllPost {
    val run = { repository : postFirestoreRepository,  ->
        repository.readAll()
    }
}