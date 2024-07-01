package com.example.haddaapp.Screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
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
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.haddaapp.Navigation.Navigate
import com.example.haddaapp.Viewmodel.HaddaViewModel

@Composable
//@Preview(showSystemUi = true)
fun RegisterScreen(navHostController: NavHostController, viewModel: HaddaViewModel) {
    val Name = remember {
        mutableStateOf("")
    }
    val Email = remember {
        mutableStateOf("")
    }
    val  PhoneNo = remember {
        mutableStateOf("")
    }
    val Address = remember {
        mutableStateOf("")
    }
    val Password = remember {
        mutableStateOf("")
    }
    val ConfirmPassword = remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .padding(bottom = 100.dp)
                .fillMaxWidth().fillMaxHeight()
        ) {
            OutlinedTextField(value = Name.value, onValueChange = {
                Name.value = it
            }, modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(.8f).height(55.dp), placeholder = { Text(text = "Enter Your Name") }, leadingIcon = { Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null
            )
            }, singleLine = true)
            OutlinedTextField(value = Email.value, onValueChange = {
                Email.value = it
            }, modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(.8f).height(55.dp),placeholder = { Text(text = "Enter Your Email") }, leadingIcon = { Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null
            )
            }, singleLine = true)

            OutlinedTextField(value = PhoneNo.value, onValueChange = {
               PhoneNo.value = it
            }, modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(.8f).height(55.dp),placeholder = { Text(text = "Enter Your Phone No") }, leadingIcon = { Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = null
            )
            }, singleLine = true)
            OutlinedTextField(value = Address.value, onValueChange = {
                Address.value = it
            }, modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(.8f).height(55.dp),placeholder = { Text(text = "Enter Your Address") }, leadingIcon = { Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null
            )
            }, singleLine = true)

            OutlinedTextField(value = Password.value, onValueChange = {
                Password.value = it
            }, modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(.8f).height(55.dp),placeholder = { Text(text = "Enter Your Password") }, leadingIcon = { Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null
            )
            }, singleLine = true)

            OutlinedTextField(value = ConfirmPassword.value, onValueChange = {
                ConfirmPassword.value = it
            }, modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(.8f).height(55.dp),placeholder = { Text(text = "Enter Your Confirm Password") }, leadingIcon = { Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null
            )
            }, singleLine = true)
            Button(onClick = {
                if (Name.value.isNotBlank()&&Email.value.isNotBlank()&&PhoneNo.value.isNotBlank()&&Address.value.isNotBlank()&&Password.value.isNotBlank()&&ConfirmPassword.value.isNotBlank()){
                    if (ConfirmPassword.value==Password.value){

                        viewModel.Register(Name.value,Email.value.lowercase(),PhoneNo.value,Address.value,Password.value)
                        Log.d("VisSign","Sign up Request sent")
                    }
                    else{
                        Log.d("CHECKLOG","PASSWORD NOT MATCHING")
                    }
                }
            }, colors = ButtonDefaults.buttonColors(Color.Yellow), border = BorderStroke(1.dp,
                Color.Black), modifier = Modifier.padding(vertical = 5.dp)) {
                Text(text = "Sign Up", color = Color.Black)
            }

            Row(horizontalArrangement = Arrangement.Center) {
                Text(text = "Already Have Account ? Click to Login", modifier = Modifier
                    .clickable {
                        navHostController.navigate(Navigate.Login.route){
                            popUpTo(0)
                        }
                    }
                    .padding(vertical = 10.dp))
            }

        }
    }
}


//Ui Check
