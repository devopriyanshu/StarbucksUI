package com.example.starbucksui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun StartNavigation(){
    val navHostController = rememberNavController()
    
    NavHost(navController = navHostController, startDestination = start){
        composable(start){
            StartScreen(navHostController)
        }
        composable(home){
            HomeScreen(navHostController)
        }
        composable(product_detail){
            ProductDetailScreen(navHostController)
        }
    }
}

const val start = "start_screen"
const val home = "home_screen"
const val product_detail = "product_detail_screen"