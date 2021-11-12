package com.principal.core.shared.infraesctructure.persistence

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

open class FirebaseRepository {
    protected val DATABASE = Firebase.firestore


}