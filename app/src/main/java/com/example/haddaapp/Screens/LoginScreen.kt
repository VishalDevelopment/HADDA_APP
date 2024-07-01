package com.example.haddaapp.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.haddaapp.Navigation.Navigate
import com.example.haddaapp.Viewmodel.HaddaViewModel

@Composable
//@Preview(showBackground = true)
fun LoginScreen(navcontroller: NavHostController, viewModel: HaddaViewModel) {
    val Email = remember {
        mutableStateOf("")
    }
    val Password = remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(bottom = 100.dp)
        ) {
            OutlinedTextField(value = Email.value, onValueChange = {
                Email.value = it
            }, modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth(.8f).height(55.dp), placeholder = { Text(text = "Email")}, leadingIcon = { Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null
            )}, singleLine = true)
            OutlinedTextField(value = Password.value, onValueChange = {
                Password.value = it
            }, modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth(.8f).height(55.dp),placeholder = { Text(text = "Password")}, leadingIcon = { Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null
            )}, singleLine = true)

            Button(onClick = {
                //Sign-In Logic
                viewModel.Login(Email.value.lowercase(),Password.value)

            }, colors = ButtonDefaults.buttonColors(Color.Yellow), border = BorderStroke(1.dp,Color.Black), modifier = Modifier.padding(vertical = 5.dp)) {
                Text(text = "Sign In", color = Color.Black)
            }

            Row(horizontalArrangement = Arrangement.Center) {
                Text(text = "New user ? Click to Create Account", modifier = Modifier.clickable {
                    navcontroller.navigate(Navigate.Register.route){
                        popUpTo(Navigate.Login.route)
                    }
                }.padding(vertical = 10.dp))
            }
        }
    }
}