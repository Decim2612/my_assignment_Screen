package com.example.my_assignment_file.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.my_assignment_file.DestinationScreen
import com.example.my_assignment_file.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Box(modifier=Modifier.verticalScroll(rememberScrollState())) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.location_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(top = 10.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Work",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 5.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.scroll_icon),
                    modifier = Modifier
                        .size(30.dp)
                        .padding(top = 10.dp),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.padding(end = 145.dp))
                Text(
                    text = "Hello!Jhon",
                    fontFamily = FontFamily.Default,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(top = 5.dp),

                    )
            }
            val (searchText, setSearchText) = remember { mutableStateOf("") }
            SearchBar(
                searchText = searchText,
                onSearchTextChanged = { text -> setSearchText(text) }
            )
            HorizontalScrollWithCards()
            text(title = "MY NEXT MEALS")
            Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
                midFrame("Biryani", "Dinner", "Arriving: 8:30pm")
            }
            text(title = "SUBSCRIPTIONS")

                subscriptions(navController)

            text(title = "POPULAR MEALS")
            horizontalScrollwithImage()
            text(title = "OFFERS JUST FOR YOU")
            lowerframe()
          BottomNavigationMenu(selectedItem = BottomNavigationItem.HOMELIST, navController = navController)
        }

    }
}

@Composable
fun lowerframe(){
    val item= listOf(R.drawable.banner_icon,R.drawable.banner_icon,R.drawable.banner_icon)
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(3) { it ->
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {

                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = item[it]),
                            contentDescription = null,
                            modifier = Modifier
                                .size(width = 200.dp, height = 100.dp)
                                .clickable { }
                        )
                    }
                }


            }

        }
    }

}

@Composable
fun text(title: String) {
    Row {

        Text(

            text = title,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            textAlign = TextAlign.Center
        )
    }

}

@Composable
fun utilsub(text: String, id: Int,route:String,navController: NavController) {
    Column {
        Image(
            painter = painterResource(id = id), contentDescription = null, modifier = Modifier
                .size(120.dp)
                .padding(4.dp)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = text, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { navigateto(navController, route) }, fontWeight = FontWeight.Light
        )
    }
}

@Composable
fun subscriptions(navController: NavController) {
    Row(Modifier.padding(12.dp)) {
        utilsub(text = "BREAKFAST", id = R.drawable.breakfast_icon,DestinationScreen.Home.route, navController)
        utilsub(text = "LUNCH", id = R.drawable.lunch_icon,DestinationScreen.Lunch.route, navController)
        utilsub(text = "DINNER", id = R.drawable.dinner_icon,DestinationScreen.Home.route, navController)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun midFrame(title: String, timing: String, time: String) {
    Row {
        Row {
            Image(
                painter = painterResource(id = R.drawable.biryani_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
            Column {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default,
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.padding(bottom = 17.dp))
                Text(
                    text = timing,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Default,
                    modifier = Modifier.padding(start = 4.dp)
                )
                Row {
                    Text(
                        text = time,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.Default,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.outlinedButtonColors(Color.Transparent),
                        modifier = Modifier.padding(start = 75.dp)
                    ) {
                        Text(text = "Edit")
                    }
                }

            }


        }
    }
}

@Composable
fun horizontalScrollwithImage() {
    val dishes = listOf(
        R.drawable.biryani2_icon,
        R.drawable.chicken_thali_icon,
        R.drawable.pulao_icon,
        R.drawable.veg_thali_icon
    )
    val disheNames = listOf("Veg-Thali", "Chicken-Thali", "Pulao", "Biryani")
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(4) { dish ->
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {

                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = dishes[dish]),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )
                        Text(
                            text = disheNames[dish],
                            modifier = Modifier
                                .clickable { }
                                .align(Alignment.CenterHorizontally),
                            fontWeight = FontWeight.Light,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                }


            }

        }
    }

}

@Composable
fun HorizontalScrollWithCards() {
    val filters = listOf("Sort by", "Veg", "Non-veg", "4+ rating", "Under 100")

    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(5) { filter ->
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Card(
                    modifier = Modifier
                        .width(120.dp)
                        .background(Color.Transparent),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = filters[filter],
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    searchText: String,
    onSearchTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        TextField(
            modifier = Modifier
                .weight(1f),
            value = searchText,
            onValueChange = { onSearchTextChanged(it) },
            placeholder = { Text("Search") },
            shape = RoundedCornerShape(80.dp),
            colors = TextFieldDefaults.textFieldColors(
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )

        )
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(15.dp)
                    .padding(end = 4.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(title: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(color = Color.White) // Set white background color
    ) {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.background
                )
            },
            modifier = Modifier.background(Color.White),
        )
    }
}
