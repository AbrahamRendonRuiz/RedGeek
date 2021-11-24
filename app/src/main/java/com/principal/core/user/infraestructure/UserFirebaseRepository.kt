package com.principal.core.user.infraestructure
import com.principal.core.shared.infraesctructure.persistence.FirebaseRepository
import com.principal.core.user.model.user
import com.principal.core.user.model.userRepository

open class UserFirebaseRepository : userRepository, FirebaseRepository() {



    override fun create(user: user?): Boolean {
        var state : Boolean = false
        AUTH.createUserWithEmailAndPassword(user?.userName.toString(),user?.password.toString()).
            addOnCompleteListener {task ->
                state = task.isSuccessful

            }
        return state
    }

    override fun readAll(): Array<user?>? {
        TODO("Not yet implemented")
    }

    override fun deleteUser(user: user?): user? {
        TODO("Not yet implemented")
    }

    override fun readUser(user: user?): user? {
         val us = AUTH.currentUser
        if(us != null){
            us.let {
                user?.userName = us.email.toString()
            }
        }
        return user
    }


}