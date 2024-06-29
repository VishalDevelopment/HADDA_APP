package com.example.haddaapp.Screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true, heightDp = 500, widthDp = 300)
fun SupportScreen() {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            Row(
                horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ) {
                Text(
                    text = "Hadda Support ",
                    fontSize = 25.sp,
                    fontFamily = FontFamily.SansSerif
                )
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {


                }, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(
                    Color.Yellow), border = BorderStroke(0.5.dp,Color.Black)
                ) {
                    Text(text = "Email US", color = Color.Black)
                }
                Button(onClick = {
                    //Call Button Working
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data= Uri.parse("tel:8851688279")
                    context.startActivity(intent)
                }, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(
                    Color.Yellow), border = BorderStroke(0.5.dp,Color.Black)
                ) {
                    Text(text = "Call Us ",color = Color.Black)
                }
            }
        }
    }

}