package com.example.haddaapp.Screens

import android.util.Log
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.haddaapp.Models.OrderProduct
import com.example.haddaapp.Models.ProductResponse
import com.example.haddaapp.R
import com.example.haddaapp.Viewmodel.HaddaViewModel

@Composable
fun HomeScreen(viewmodel: HaddaViewModel) {


    val Products = viewmodel.ProductList.collectAsState(initial = emptyList())

    if (Products.value!= mutableListOf(emptyList<ProductResponse>())){
        Box(modifier = Modifier.fillMaxSize()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(Products.value){
                    ItemView(it,viewmodel)
                }
            }
        }
    }
    else{
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun ItemView(products: ProductResponse, viewmodel: HaddaViewModel) {
    val Unit = remember {
        mutableStateOf(products.Unit)
    }
    Card(
        elevation = CardDefaults.elevatedCardElevation(3.dp), modifier = Modifier
            .width(150.dp)
            .padding(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.wheat_bag),
                contentDescription = null
            )

            Text(
                text = "${products.category}",
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 3.dp),
                fontWeight = FontWeight.Medium
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.outline_check_indeterminate_small_24),
                    modifier = Modifier
                        .size(40.dp)
                        .weight(1f)
                        .clickable {
                            if (Unit.value > 0) {
                                Unit.value--
                            }
                        },
                    contentDescription = null
                )
                Text(
                    text = Unit.value.toString(),
                    fontSize = 32.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(id = R.drawable.baseline_add_24),
                    modifier = Modifier
                        .size(40.dp)
                        .weight(1f)
                        .clickable {
                            if (Unit.value < 10) {
                                Unit.value++
                            }

                        },
                    contentDescription = null
                )

            }

            Button(
                onClick = {
                    if (Unit.value > 0) {
//                        viewmodel.OrderProductList.value.add(ProductResponse(products.id,products.category,Unit.value,products.price,products.status))
                        viewmodel.OrderProductList.value.add(ProductResponse(Unit.value,products.category,products.id,products.price,products.status))
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 3.dp),
                colors = ButtonDefaults.buttonColors(Color.Yellow),
                border = BorderStroke(0.5.dp, Color.Black)
            ) {
                Text(
                    text = "Add to cart ",
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }


}


