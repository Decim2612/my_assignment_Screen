package com.example.my_assignment_file.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.my_assignment_file.DestinationScreen
import com.example.my_assignment_file.R

@Composable
fun LunchScreen(navController: NavController) {
    Box(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Row {
                Button(
                    onClick = { navigateto(navController,DestinationScreen.Home.route) },
                    colors = ButtonDefaults.outlinedButtonColors(Color.Transparent)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back_icon),
                        contentDescription = null, modifier = Modifier.size(25.dp)
                    )
                }
                Text(
                    text = "Lunch",
                    modifier = Modifier.padding(top = 10.dp, start = 85.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )
            }
            val (searchText, setSearchText) = remember { mutableStateOf("") }
            SearchBar(
                searchText = searchText,
                onSearchTextChanged = { text -> setSearchText(text) }
            )
            HorizontalScrollWithCards()
            midarea("Aruna Mess", "1.2Km", "4.2", "19min")
            Spacer(modifier = Modifier.padding(0.5.dp))
            midarea("Aruna Mess", "1.2Km", "4.2", "19min")
            Spacer(modifier = Modifier.padding(0.5.dp))
            midarea("Aruna Mess", "1.2Km", "4.2", "19min")
            Spacer(modifier = Modifier.padding(0.5.dp))
            midarea("Aruna Mess", "1.2Km", "4.2", "19min")




        }
    }
}

@Composable
fun midarea(title: String, distance: String, rating: String, timing: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Row {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(end = 190.dp))
                Icon(
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = null,
                    Modifier
                        .rotate(180f)
                        .padding(8.dp)
                        .size(25.dp)
                        .clickable { }
                )
            }
            Row {
                Text(text = rating, fontWeight = FontWeight.SemiBold)
                Icon(
                    painter = painterResource(id = R.drawable.star_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(15.dp)
                        .padding(top = 4.dp), tint = Color.Red
                )
                Spacer(modifier = Modifier.padding(end = 10.dp))
                Text(text = timing + '|', fontWeight = FontWeight.SemiBold)
                Text(text = distance, fontWeight = FontWeight.SemiBold)


            }

            Text(
                text = "Starts from $99 only",
                Modifier.padding(4.dp),
                fontWeight = FontWeight.Light
            )
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                cardUtil(
                    name = "Non-veg Thali",
                    des = "Chicken + 3 Roti",
                    rate = "125$",
                    rating = "4.7",
                    number = 78,
                    type = "Non-veg"
                )
                Spacer(modifier = Modifier.padding(4.dp))
                cardUtil(
                    name = "Veg Thali",
                    des = "3 Roti",
                    rate = "125$",
                    rating = "4.5",
                    number = 78,
                    type = "veg"
                )
                Spacer(modifier = Modifier.padding(4.dp))
                cardUtil(
                    name = "Veg Thali",
                    des = "3 Roti",
                    rate = "125$",
                    rating = "4.7",
                    number = 78,
                    type = "veg"
                )

            }

        }

    }
}

@Composable
fun cardUtil(name: String, des: String, rate: String, rating: String, number: Int, type: String) {
    Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {

            Row(modifier = Modifier.padding(8.dp)) {
                Column {
                    if (type == "Non-veg") {
                        Icon(
                            painter = painterResource(id = R.drawable.meat_icon),
                            contentDescription = null,
                            tint = Color.Red, modifier = Modifier.size(10.dp)
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.vegan_icon),
                            contentDescription = null,
                            tint = Color.Green, modifier = Modifier.size(10.dp)
                        )

                    }
                    Text(text = name, fontWeight = FontWeight.Light, fontSize = 17.sp)
                    Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    Text(text = des, fontWeight = FontWeight.Light, fontSize = 14.sp)
                    Text(text = rate, Modifier.padding(top = 5.dp), fontWeight = FontWeight.Light)
                    Row {
                        Text(
                            text = rating,
                            Modifier.padding(start = 8.dp),
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.star_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(15.dp)
                                .padding(top = 4.dp), tint = Color.Red
                        )
                        Text(
                            text = '(' + number.toString() + ')',
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light
                        )
                    }


                }
                Spacer(modifier = Modifier.padding(start = 70.dp, end = 70.dp))
                  Column {
                      Image(painter = painterResource(id = R.drawable.thali_icon), contentDescription = null,Modifier.size(75.dp))
                      Button(onClick = { }, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary) ) {
                          Text(text = "ADD", color = MaterialTheme.colorScheme.background)
                      }

                  }
                

            }
        }

}