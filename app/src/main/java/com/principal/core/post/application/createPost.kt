package com.principal.core.post.application

import com.principal.core.post.infraestructure.postFirestoreRepository
import com.principal.core.post.model.post

import com.principal.core.user.model.user

class createPost {
    /*val run ={ repository : UserFirebaseRepository, name: String, password : String ->
        repository.create(user(name,password))}*/
    val run = {repository : postFirestoreRepository,username:String,PostContent : String ->
        repository.create(user(username),post(PostContent))
    }

}