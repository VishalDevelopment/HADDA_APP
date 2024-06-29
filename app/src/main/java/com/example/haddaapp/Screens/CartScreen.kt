package com.example.haddaapp.Screens

import android.util.Log
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.haddaapp.Models.Products
import com.example.haddaapp.R
import com.example.haddaapp.Viewmodel.HaddaViewModel

@Composable
fun CartScreen(viewmodel: HaddaViewModel) {
    val productList = viewmodel.productList
    Log.d("VishalproductList", "${productList.value}")
    val checkProducts = remember {
        if (productList.value.isEmpty()) {
            mutableStateOf(false)
        } else {
            mutableStateOf(true)
        }
    }
    Log.d("VishalcheckProducts", "${checkProducts.value}")


    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        if (checkProducts.value == true) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxHeight(.85f)
                    .fillMaxWidth()
            ) {
                LazyColumn(modifier = Modifier.padding(vertical = 15.dp)) {
                    items(productList.value) {
                        ListView(it)
                        Spacer(modifier = Modifier.padding(vertical = 5.dp))
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight(.15f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    //Button Click Code
                },
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)) {
                    Text(text = "Order Items")
                }
            }
        }

        if (checkProducts.value == false) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.shopping_cart), contentDescription = null)
            }
        }
    }
}




@Composable

fun ListView(products: Products) {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth(.95f)
            .border(0.5.dp, Color.Black, shape = RectangleShape)
            .padding(vertical = 8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.wheat_bag),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)

            )

            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = "Category : ${products.category}", fontSize = 20.sp)
                Text(text = "Unit : ${products.Unit}", fontSize = 20.sp)
            }
        }
    }
}