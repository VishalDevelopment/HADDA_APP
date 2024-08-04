package com.example.haddaapp.Navigation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.haddaapp.R
import com.example.haddaapp.Screens.AboutUsScreen
import com.example.haddaapp.Screens.CartScreen
import com.example.haddaapp.Screens.HomeScreen
import com.example.haddaapp.Screens.OrderScreen
import com.example.haddaapp.Screens.ProfileScreen
import com.example.haddaapp.Screens.SupportScreen
import com.example.haddaapp.Viewmodel.HaddaViewModel
import com.example.haddaapp.ui.theme.YellowBM
import com.example.haddaapp.ui.theme.YellowJC
import kotlinx.coroutines.launch


data class BottomBarOptions(
    val name: String,
    val SelectedIcon: ImageVector,
    val UnselectedIcon: ImageVector,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation(viewmodel: HaddaViewModel) {

    val controlList = mutableListOf(
        BottomBarOptions(
            "home",
            Icons.Default.Home,
            Icons.Outlined.Home
        ),
        BottomBarOptions(
            "cart",
            Icons.Default.ShoppingCart,
            Icons.Outlined.ShoppingCart
        )
    )
    val selectedIcon = remember {
        mutableStateOf(Icons.Default.Home)
    }

    val navController = rememberNavController()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(300.dp) // Set the desired width for the drawer
                    .fillMaxHeight(),
            ) {
                    Column(modifier = Modifier
                        .background(YellowJC)
                        .fillMaxWidth().wrapContentHeight(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.wheat_bag),
                            contentDescription = null,
                            modifier = Modifier.padding(vertical = 3.dp)
                        )
                        Text(
                            text = "Welcome to Hadda App",
                            fontSize = 15.sp,
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif,
                            modifier = Modifier.padding(vertical = 3.dp)
                        )
                }
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Home") },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                    selected = false,
                    onClick = {
//                        Toast.makeText(context, "Home Clicked", Toast.LENGTH_SHORT).show()
                        navController.navigate(BottomNav.Home.name) {
                            popUpTo(0)
                        }
                        scope.launch { drawerState.close() }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Profile") },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null
                        )
                    },
                    selected = false,
                    onClick = {
                        Toast.makeText(context, "Profile Clicked", Toast.LENGTH_SHORT).show()
                        navController.navigate(DrawerNav.Profile.name) {
                            popUpTo(BottomNav.Home.name)
                        }
                        scope.launch { drawerState.close() }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "My Order") },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = null
                        )
                    },
                    selected = false,
                    onClick = {
//                        Toast.makeText(context, "My Order Clicked", Toast.LENGTH_SHORT).show()
                        navController.navigate(DrawerNav.Order.name) {
                            popUpTo(BottomNav.Home.name)
                        }
                        scope.launch { drawerState.close() }

                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Support") },
                    icon = { Icon(imageVector = Icons.Default.Call, contentDescription = null) },
                    selected = false,
                    onClick = {
//                        Toast.makeText(context, "Support Clicked", Toast.LENGTH_SHORT).show()
                        navController.navigate(DrawerNav.Support.name) {
                            popUpTo(BottomNav.Home.name)
                        }
                        scope.launch { drawerState.close() }

                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "About") },
                    icon = { Icon(imageVector = Icons.Default.Info, contentDescription = null) },
                    selected = false,
                    onClick = {
//                        Toast.makeText(context, "About Clicked", Toast.LENGTH_SHORT).show()
                        navController.navigate(DrawerNav.About.name) {
                            popUpTo(BottomNav.Home.name)
                        }
                        scope.launch { drawerState.close() }

                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "LogOut") },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = null
                        )
                    },
                    selected = false,
                    onClick = {
                        Toast.makeText(context, "Logout Clicked", Toast.LENGTH_SHORT).show()
                        viewmodel.LogOut()
                        scope.launch { drawerState.close() }

                    }
                )
            }
        },
        gesturesEnabled = true
    ) {


        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(
                                text = "Grind Hadda",
                                textAlign = TextAlign.Center,modifier = Modifier.fillMaxSize()
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = YellowJC,
                    ),
                    navigationIcon = {
                        Box(
                            modifier = Modifier.fillMaxHeight(),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            IconButton(onClick = { scope.launch { drawerState.open() } },modifier = Modifier.fillMaxHeight().padding(3.dp)) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menu Icon"
                                )
                            }
                        }
                    },
                    modifier = Modifier.height(60.dp)
                )
            },
            bottomBar = {
                BottomAppBar(containerColor = YellowJC,modifier = Modifier.height(50.dp), windowInsets = WindowInsets(0.dp)) {
                    IconButton(onClick = {
                        selectedIcon.value = Icons.Default.Home
                        navController.navigate(BottomNav.Home.name) {
                            launchSingleTop = true
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(imageVector =if (selectedIcon.value == controlList[0].SelectedIcon){
                            controlList[0].SelectedIcon
                        }
                        else{
                            controlList[0].UnselectedIcon
                        }, contentDescription = null)
                    }

                    IconButton(onClick = {
                        selectedIcon.value = Icons.Default.ShoppingCart
                        navController.navigate(BottomNav.Cart.name) {
                            launchSingleTop = true
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(imageVector =if (selectedIcon.value == controlList[1].SelectedIcon){
                            controlList[1].SelectedIcon
                        }
                        else{
                            controlList[1].UnselectedIcon
                        }, contentDescription = null)
                    }

                }
            },
        ) { innerpadding ->
            Box(Modifier.padding(innerpadding)) {
                NavHost(navController = navController, startDestination = BottomNav.Home.name) {
                    composable(BottomNav.Home.name) {
                        HomeScreen(viewmodel)
                    }
                    composable(BottomNav.Cart.name) {
                        CartScreen(viewmodel,navController,selectedIcon)

                    }
                    composable(DrawerNav.Profile.name) {
                        ProfileScreen(viewmodel)
                    }
                    composable(DrawerNav.Order.name) {
                        OrderScreen(viewmodel)
                    }
                    composable(DrawerNav.About.name) {
                        AboutUsScreen()
                    }
                    composable(DrawerNav.Support.name) {
                        SupportScreen()
                    }
                }
            }
        }
    }
}

sealed class BottomNav(val name: String) {
    object Home : BottomNav("home")
    object Cart : BottomNav("cart")
}

sealed class DrawerNav(val name: String) {
    object Profile : DrawerNav("profile")
    object Order : DrawerNav("order")
    object Support : DrawerNav("support")
    object About : DrawerNav("about")

}
