package com.principal.core.user.infraestructure
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseUser
import com.principal.core.user.model.user
import com.principal.core.user.model.userRepository

open class UserFirebaseRepository : userRepository {
    private lateinit var auth: FirebaseAuth


    override fun create(user: user?): Boolean {
        var state : Boolean = false
        auth =  FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(user?.userName.toString(),user?.password.toString()).
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
        TODO("Not yet implemented")
    }


}