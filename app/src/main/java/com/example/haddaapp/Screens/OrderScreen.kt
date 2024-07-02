package com.example.haddaapp.Screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.haddaapp.Models.MyOrderResponse
import com.example.haddaapp.R
import com.example.haddaapp.Viewmodel.HaddaViewModel

@Composable
fun OrderScreen(viewmodel: HaddaViewModel) {
    val id = viewmodel.getId().collectAsState(initial = "")
    viewmodel.getAllOrder(id.value)
    val itemsList = viewmodel.MyOrderList.collectAsState()
    Log.d("MyOrders", "${itemsList.value}")

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 30.dp)
                .align(Alignment.TopCenter)
        ) {
            items(itemsList.value) {
                Card(
                    elevation = CardDefaults.elevatedCardElevation(2.dp),
                    border = BorderStroke(0.5.dp, Color.Black),
                    modifier = Modifier.padding(5.dp)
                ) {
                    OrderListView(it)
                }
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
            }
        }
    }
}

@Composable

fun OrderListView(orderItems: MyOrderResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth(.95f)
            .border(0.5.dp, Color.Black, shape = RectangleShape)
            .padding(vertical = 0.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.wheat_bag),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp)

            )

            Column(modifier = Modifier.padding(8.dp)) {
                //Unit And Status is Missing
                Text(text = "Category : ${orderItems.category}", fontSize = 18.sp)
                Text(text = "Unit : ${orderItems.unit}", fontSize = 18.sp)
                Text(text = "Weight : ${orderItems.weight} kg", fontSize = 18.sp)
                Text(text = "Price : ₹ ${orderItems.price}", fontSize = 18.sp)
                Text(text = "Status : ${orderItems.status}", fontSize = 18.sp)

            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp, vertical = 5.dp)
        ) {
            Text(text = "Date : ${orderItems.orderDate}", fontSize = 15.sp)
            Text(text = "Time : ${orderItems.orderTiming}", fontSize = 15.sp)
        }
    }
}


@Composable
@Preview()
fun OrderListView() {
    Column(
        modifier = Modifier
            .fillMaxWidth(.95f)
            .border(0.5.dp, Color.Black, shape = RectangleShape)
            .padding(vertical = 0.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.wheat_bag),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp)

            )

            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = "Category : ", fontSize = 18.sp)
                Text(text = "Unit : ", fontSize = 18.sp)
                Text(text = "Price : ", fontSize = 18.sp)
                Text(text = "Status : ", fontSize = 18.sp)
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp, vertical = 5.dp)
        ) {
            Text(text = "Date : ", fontSize = 15.sp)
            Text(text = "Time : ", fontSize = 15.sp)
        }
    }
}