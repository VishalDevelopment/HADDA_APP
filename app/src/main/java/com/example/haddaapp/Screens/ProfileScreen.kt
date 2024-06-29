package com.example.haddaapp.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.haddaapp.R

@Composable
@Preview(showBackground = true, heightDp = 500, widthDp = 300)
fun ProfileScreen() {

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
                    .verticalScroll(rememberScrollState())) {
                Card(elevation = CardDefaults.elevatedCardElevation(1.dp), border = BorderStroke(0.2.dp,Color.Black), colors = CardDefaults.elevatedCardColors(Color.Yellow), modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = "Name : Vishal Goswami Paratph", fontSize = 13.sp, modifier = Modifier.padding(8.dp), fontFamily = FontFamily.SansSerif)
                }

                Card(elevation = CardDefaults.elevatedCardElevation(1.dp), border = BorderStroke(0.2.dp,Color.Black), colors = CardDefaults.elevatedCardColors(Color.Yellow), modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = "Email : Vishal123@Gmail.com", fontSize = 13.sp, modifier = Modifier.padding(8.dp), fontFamily = FontFamily.SansSerif)
                }
                Card(elevation = CardDefaults.elevatedCardElevation(1.dp), border = BorderStroke(0.2.dp,Color.Black), colors = CardDefaults.elevatedCardColors(Color.Yellow), modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = "Phone No : +91 8851688279", fontSize = 13.sp, modifier = Modifier.padding(8.dp), fontFamily = FontFamily.SansSerif)
                }
                Card(elevation = CardDefaults.elevatedCardElevation(1.dp), border = BorderStroke(0.2.dp,Color.Black), colors = CardDefaults.elevatedCardColors(Color.Yellow), modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = "Address : Aman Nagar Colony Qadipur Delhi -110036", fontSize = 13.sp, modifier = Modifier.padding(8.dp), fontFamily = FontFamily.SansSerif)
                }

            }

        }
    }
}
