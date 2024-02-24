package com.example.my_assignment_file

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.my_assignment_file.Screens.HomeScreen
import com.example.my_assignment_file.Screens.LunchScreen
import com.example.my_assignment_file.ui.theme.My_Assignment_fileTheme

sealed class DestinationScreen(var route: String) {
    object Home : DestinationScreen("home")
    object Lunch : DestinationScreen("Lunch")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            My_Assignment_fileTheme {
                // A surface container using the 'background' color from the theme
                appNavigation()
            }
        }
    }
}

@Composable
fun appNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = DestinationScreen.Home.route) {
        composable(DestinationScreen.Home.route) {
            HomeScreen(navController=navController)
        }
        composable(DestinationScreen.Lunch.route) {
            LunchScreen(navController=navController)
        }
    }
}

