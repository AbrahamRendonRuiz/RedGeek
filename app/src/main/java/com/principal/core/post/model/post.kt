package com.principal.core.post.model

class post (){
    var username : String  = ""
    var postContent : String = ""
    var postId : String = ""

    constructor(postContent: String) : this() {
        this.postContent = postContent
    }
}