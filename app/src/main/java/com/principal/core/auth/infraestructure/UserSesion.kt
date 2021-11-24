package com.principal.core.auth.infraestructure

import com.google.gson.Gson
import java.io.File
import java.io.IOException

data class Sesion(var username:String,var sesion : String)
class UserSesion {
    fun isActive():Boolean{
        val json = getJson()
        return json.sesion.equals("active")
    }
    fun getJson() : Sesion {
        val fileString = "auth/infraestructure/sesion.json"
        val gson = Gson()
        try{
             val br = File(fileString).bufferedReader()
             val inputS = br.use { it.readText() }
             val post = gson.fromJson(inputS,Sesion::class.java)
             val sesion = Sesion(post.username,post.sesion)
            return  sesion

        }catch (e:IOException){
            val sesion = Sesion("","")
            return sesion
        }
    }
}