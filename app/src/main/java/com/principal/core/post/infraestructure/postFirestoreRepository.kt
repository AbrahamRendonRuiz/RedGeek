package com.principal.core.post.infraestructure

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.principal.core.post.model.post
import com.principal.core.post.model.postRepository
import com.principal.core.shared.infraesctructure.persistence.FirebaseRepository
import com.principal.core.user.model.user

class postFirestoreRepository : postRepository, FirebaseRepository() {

     val Posts = arrayListOf<post>()
    private var postings = post()


    override fun create(User: user, Post: post): post {
        val post = hashMapOf(
            "POSTCONTENT" to Post.postContent,
            "USERNAME" to User.userName
        )
        DATABASE.collection("POST")
        .add(post)
        .addOnSuccessListener { documentReference ->
            Log.d(TAG,"DocumentSnapshot added whit ID :${documentReference.id}")

        }
        .addOnFailureListener{e ->
            Log.d(TAG,"Error Adding Document", e)
        }
        return Post
    }

    override fun edit(User: user, Post: post): post {
        TODO("Not yet implemented")
    }

    override fun delete(Post: post) {
        
    }

    override fun read(User: user): ArrayList<post> {
        DATABASE.collection("POST")
            .whereEqualTo(User.userName,true)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents ){
                    postings.postContent = document.get("POSTCONTENT") as String
                    postings.username = document.get("USERNAME") as String
                    Posts.add(postings)
                }
            }
        return Posts
    }

    override fun readAll() : ArrayList<post>{

        DATABASE.collection("POST").get().addOnSuccessListener { documents ->

            for (document in documents ){
                postings.postContent = document.get("POSTCONTENT") as String
                postings.username = document.get("USERNAME") as String
                Posts.add(postings)
            }
        }
        return Posts
    }

}