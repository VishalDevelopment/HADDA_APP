package com.example.haddaapp.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.haddaapp.R

@Composable
@Preview(showBackground = true, heightDp = 800, widthDp = 500)
fun AboutUsScreen() {
    val title = stringResource(id = R.string.title)
    val des = stringResource(id = R.string.Description_Shop)
    val headpoint = stringResource(id = R.string.heading_points)
    val points = stringResource(id = R.string.Imp_Points)
    val quote =  stringResource(id = R.string.Quote1)
    val headprice = stringResource(id = R.string.heading_price)
    val price = stringResource(id = R.string.Pricing)
    val quote2 = stringResource(id = R.string.Quote2)
    val wc = stringResource(id = R.string.Welcome_Line)
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 5.dp ,end = 5.dp , top = 10.dp , bottom = 3.dp).fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(vertical = 3.dp)
            )
            Text(
                text = des,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(vertical = 3.dp)
            )
            Text(
                text = headpoint,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Start,
                modifier = Modifier.padding(vertical = 3.dp)
            )
            Text(
                text = points,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(vertical = 3.dp)
            )
            Text(
                text = quote,
                fontSize = 20.sp,
                fontWeight = FontWeight.Light, textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 5.dp)
            )
            Text(
                text = headprice,
                fontSize =20.sp,
                fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Start,
                modifier = Modifier.padding(vertical = 5.dp)
            )
            Text(
                text = price,
                fontSize =18.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(vertical = 5.dp)
            )

            Text(
                text = quote2,
                fontSize =18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 5.dp)
            )

            Text(
                text = wc,
                fontSize =18.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }
    }
}