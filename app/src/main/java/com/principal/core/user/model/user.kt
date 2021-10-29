package com.principal.core.user.model

class user (){
    var name : String = ""
    var surName :String = ""
    var password : String = ""
    var userName : String = ""

    constructor(name: String, surName: String, password: String, userName: String) : this() {
        this.name = name
        this.surName = surName
        this.password = password
        this.userName = userName
    }

    constructor(name: String, surName: String) : this() {
        this.name = name
        this.surName = surName
    }


}