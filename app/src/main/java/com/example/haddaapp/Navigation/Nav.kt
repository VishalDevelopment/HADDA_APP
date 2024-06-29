package com.example.haddaapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.haddaapp.Screens.LoginScreen
import com.example.haddaapp.Screens.RegisterScreen

@Composable
fun Nav(){
    val navcontroller = rememberNavController()
    NavHost(navController = navcontroller, startDestination = Navigate.Login.route ){
        composable(Navigate.Login.route){
            LoginScreen(navcontroller)
        }
        composable(Navigate.Register.route){
            RegisterScreen(navcontroller)
        }
        
    }
}

sealed class Navigate(val route :String){
    object Login : Navigate("login")
    object Register:Navigate("register")
    
}