package com.example.haddaapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.haddaapp.Screens.LoginScreen
import com.example.haddaapp.Screens.RegisterScreen
import com.example.haddaapp.Viewmodel.HaddaViewModel

@Composable
fun Nav(viewModel: HaddaViewModel) {
    val navcontroller = rememberNavController()
    NavHost(navController = navcontroller, startDestination = Navigate.Login.route ){
        composable(Navigate.Login.route){
            LoginScreen(navcontroller,viewModel)
        }
        composable(Navigate.Register.route){
            RegisterScreen(navcontroller,viewModel)
        }
        
    }
}

sealed class Navigate(val route :String){
    object Login : Navigate("login")
    object Register:Navigate("register")
    
}