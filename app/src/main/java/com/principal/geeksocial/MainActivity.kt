package com.principal.geeksocial



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.graphics.Color
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.auth.User
import com.principal.core.user.application.createUser
import com.principal.core.user.infraestructure.UserFirebaseRepository
import com.principal.core.user.model.user
import com.principal.core.user.model.userRepository
import com.principal.geeksocial.ui.theme.GeekSocialTheme

class MainActivity : ComponentActivity() {
    private val Repository = UserFirebaseRepository()
    private var Usuario = user()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GeekSocialTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyComponent(Usuario,Repository)
                }
            }
        }
    }
}

@Composable
fun MyComponent( User : user, Repository : UserFirebaseRepository) {
    Column() {

        MyTexts()
        MyTextFields(User)
        MyButton(User,Repository)

        }
}

@Composable
fun MyTexts(){
    Column(){
        MyText("GeekSocial")
        MyText("Bienvenidos")
    }
}
@Composable
fun MyText(text : String) {
    Text(text)
}
@Composable
fun MyButton(User : user, Repository: UserFirebaseRepository){
    var create = createUser()
    Column() {
        Button(onClick = {
                create.run(Repository,User.userName,User.password)
        }, border = BorderStroke(0.dp, Color.Red)) {
            Text(
                text = "Register",
                modifier = Modifier.padding(1.dp)


            )
        }


    }
}
@Composable
fun MyTextFields(User: user){
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var sname by remember { mutableStateOf("") }
    Column() {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("e-mail") }
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("password") }
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("confirm password") }
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
        OutlinedTextField(
            value = sname,
            onValueChange = { sname = it },
            label = { Text("Surname") }
        )

        User.name = name
        User.password = password
        User.userName = email
        User.surName = sname

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GeekSocialTheme {
        var User : user = user()
        var repository = UserFirebaseRepository()
        MyComponent(User,repository)
    }
}