package com.example.haddaapp

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.haddaapp.Navigation.BottomNavigation
import com.example.haddaapp.Navigation.Nav
import com.example.haddaapp.Screens.ProfileScreen
import com.example.haddaapp.Viewmodel.HaddaViewModel
import com.example.haddaapp.ui.theme.HADDAAPPTheme
import com.example.haddaapp.ui.theme.StatusYellow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HADDAAPPTheme {
                val viewModel:HaddaViewModel by viewModels<HaddaViewModel>(factoryProducer = { object :ViewModelProvider.Factory{ override fun <T : ViewModel> create(modelClass: Class<T>): T { return HaddaViewModel(applicationContext) as T } } })
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
    val id = viewModel.getId().collectAsState(initial = "")

    val view = LocalView.current
    val window = (view.context as Activity).window
    window.statusBarColor = StatusYellow.toArgb()
    Log.d("VisID",id.value.toString())
    if (id.value==""&&id.value.isNullOrBlank()){
        Nav(viewModel)
    }
    else{
        BottomNavigation(viewModel)
    }

}







