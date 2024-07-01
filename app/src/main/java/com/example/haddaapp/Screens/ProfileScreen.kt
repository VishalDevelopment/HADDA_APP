package com.example.haddaapp.Screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.haddaapp.Models.UserProfile
import com.example.haddaapp.R
import com.example.haddaapp.Viewmodel.HaddaViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ProfileScreen(viewmodel: HaddaViewModel) {

    val id = viewmodel.getId().collectAsState(initial = "")
     viewmodel.getUserInfo(id.value)
    val info = viewmodel.UserInfo.collectAsState()

    val infoState = remember {

    }

    Box(
        modifier = Modifier
            .fillMaxSize()  // Fills the entire available space
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,modifier=Modifier.fillMaxSize()
        ) {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)){
                Image(painter = painterResource(id = R.drawable.avatar), contentDescription = null, modifier = Modifier.size(120.dp))
            }
            Column(
                Modifier
                    .fillMaxHeight(.90f)
                    .fillMaxWidth()
                    .padding(10.dp)
                    .verticalScroll(rememberScrollState())
                    ) {
                Card(elevation = CardDefaults.elevatedCardElevation(1.dp), border = BorderStroke(0.2.dp,Color.Black), colors = CardDefaults.elevatedCardColors(Color.Yellow), modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = "Name : ${info.value!!.name}", fontSize = 13.sp, modifier = Modifier.padding(8.dp), fontFamily = FontFamily.SansSerif)
                }

                Card(elevation = CardDefaults.elevatedCardElevation(1.dp), border = BorderStroke(0.2.dp,Color.Black), colors = CardDefaults.elevatedCardColors(Color.Yellow), modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = "Email : ${info.value!!.email}", fontSize = 13.sp, modifier = Modifier.padding(8.dp), fontFamily = FontFamily.SansSerif)
                }
                Card(elevation = CardDefaults.elevatedCardElevation(1.dp), border = BorderStroke(0.2.dp,Color.Black), colors = CardDefaults.elevatedCardColors(Color.Yellow), modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = "Phone No : +91 ${info.value!!.phone_no}", fontSize = 13.sp, modifier = Modifier.padding(8.dp), fontFamily = FontFamily.SansSerif)
                }
                Card(elevation = CardDefaults.elevatedCardElevation(1.dp), border = BorderStroke(0.2.dp,Color.Black), colors = CardDefaults.elevatedCardColors(Color.Yellow), modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = "Address : ${info.value!!.address}", fontSize = 13.sp, modifier = Modifier.padding(8.dp), fontFamily = FontFamily.SansSerif)
                }
            }
        }
    }
}

