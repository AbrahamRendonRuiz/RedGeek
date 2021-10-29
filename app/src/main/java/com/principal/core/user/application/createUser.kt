package com.principal.core.user.application

import com.principal.core.user.infraestructure.UserFirebaseRepository
import com.principal.core.user.model.user
import com.principal.core.user.model.userRepository

class createUser {
    val run ={repository : UserFirebaseRepository, name: String,password : String ->
                repository.create(user(name,password))}
    /*var repository: userRepository? = null

    fun CreateUser(repository: userRepository?) {
        this.repository = repository
    }

    fun run(name: String, surName: String) {
        repository?.create(user(name, surName))
    }

    //new CreateUser(new UserMySQLREpository()).run('', '')*/
}

