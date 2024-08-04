package com.example.haddaapp.Screens

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.haddaapp.Models.ProductResponse
import com.example.haddaapp.Navigation.BottomNav
import com.example.haddaapp.R
import com.example.haddaapp.Viewmodel.HaddaViewModel

@Composable
fun CartScreen(viewmodel: HaddaViewModel, navController: NavHostController, selectedIcon: MutableState<ImageVector>) {
    BackHandler {
        if(selectedIcon.value == Icons.Default.ShoppingCart){
            selectedIcon.value = Icons.Default.Home
            navController.navigate(BottomNav.Home.name){
                popUpTo(0)
            }
        }
    }
    var productList = viewmodel.OrderProductList
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
                        ListView(it){ removedProduct ->
                            // Handle product removal on close icon click
                            productList.value.remove(removedProduct)
                            checkProducts.value = productList.value.isNotEmpty() // Update empty state
                        }
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
                val id = viewmodel.getId().collectAsState(initial = "")
                viewmodel.getUserInfo(id.value)
                val info = viewmodel.UserInfo.collectAsState()
                val context = LocalContext.current
                Button(onClick = {
                    productList.value.map {
                        if(it.id == 1){
                            it.price =it.Unit.toDouble()* it.price
                        }
                        viewmodel.placeOrder(info.value.userID,info.value.name,info.value.email,info.value.phone_no,it.category,it.Unit,it.price,info.value.address
                        )
                    }
                    if (checkProducts.value==true){
                        checkProducts.value=false
                        Toast.makeText(context, "Order Placed Successfully !!", Toast.LENGTH_SHORT).show()
                        productList.value.clear()
                    }
                }, colors = ButtonDefaults.buttonColors(Color.Yellow), border = BorderStroke(1.dp,Color.Black), modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)) {
                    Text(text = "Order Items", color = Color.Black)
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

fun ListView(product: ProductResponse, onRemove: (Any) -> Unit) {
    Card(elevation = CardDefaults.elevatedCardElevation(2.dp), border = BorderStroke(1.dp,Color.Black), modifier = Modifier.padding(5.dp)){
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxWidth(.95f)
                .border(0.5.dp, Color.Black, shape = RectangleShape)
                .padding(vertical = 8.dp)
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.wheat_bag),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(8.dp)

                    )

                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = "Category :  ${product.category}", fontSize = 20.sp)
                        Text(text = "Unit : ${product.Unit}", fontSize = 20.sp)
                    }
                    IconButton(onClick = { onRemove(product) }) {
                        Icon(Icons.Default.Close, contentDescription = "Remove from Cart")
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 3.dp)
                ) {
                    Text(text = "Weight : 0.00 kg", fontSize = 20.sp)
                    Text(text = "Price : ₹ 0.00", fontSize = 20.sp)
                }
            }
        }
    }
}

