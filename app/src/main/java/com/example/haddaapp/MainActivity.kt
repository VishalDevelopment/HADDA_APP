package com.example.haddaapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.haddaapp.Navigation.BottomNavigation
import com.example.haddaapp.Navigation.Nav
import com.example.haddaapp.Navigation.Navigate
import com.example.haddaapp.Viewmodel.HaddaViewModel
import com.example.haddaapp.ui.theme.HADDAAPPTheme
import com.example.haddaapp.ui.theme.StatusYellow


    var startdestination = mutableStateOf(NavStart.LoginScreen.route)
class MainActivity : ComponentActivity() {

    val viewModel:HaddaViewModel by viewModels<HaddaViewModel>(factoryProducer = { object :ViewModelProvider.Factory{ override fun <T : ViewModel> create(modelClass: Class<T>): T { return HaddaViewModel(applicationContext) as T } } })

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splash

            }
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HADDAAPPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(Modifier.padding(innerPadding)){
                        StartApp(viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun StartApp(viewModel: HaddaViewModel){


    val view = LocalView.current
    val window = (view.context as Activity).window
    window.statusBarColor = StatusYellow.toArgb()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startdestination.value ){
        composable(NavStart.Homepage.route){
            BottomNavigation(viewModel)
        }
        composable(NavStart.LoginScreen.route){
            Nav(viewModel)
        }
    }
}

sealed class NavStart (val route:String){
    object LoginScreen : NavStart("login")
    object Homepage: NavStart("homepage")
}






