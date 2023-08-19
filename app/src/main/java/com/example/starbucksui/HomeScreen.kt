package com.example.starbucksui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navHostController: NavHostController){
 var menulist = listOf("All", "Coffee", "Tea", "Beer", "Wine")
 Box(modifier = Modifier.fillMaxSize()
  ){
  Column(modifier = Modifier
   .fillMaxSize()
   .padding(20.dp)) {
   Header()
   LazyColumn{
    item { Text(text = "Our way of\nloving back", style = TextStyle(fontSize = 8.em), modifier = Modifier.padding(vertical = 30.dp)) }
    item {
     Box {
     SearchBar()
    }
    }
    item {
     LazyRow(modifier = Modifier.padding(vertical = 16.dp)){
      items(menulist){
      }
     } }

   }


  }
 }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(){
 var text by remember{ mutableStateOf("") }
 TextField(value = text, onValueChange = {text = it} , label = {Text("Search")}, leadingIcon = {Icon(
  Icons.Filled.Search, contentDescription = null)}, modifier = Modifier.fillMaxWidth())
}
@Composable
 fun Header(){
  Row(modifier= Modifier
   .fillMaxWidth()
   .padding(top = 16.dp),
   horizontalArrangement = Arrangement.SpaceBetween
  ) {
   Icon(painter = painterResource(id = R.drawable.baseline_menu_24), contentDescription = "", )
   Icon(painter = painterResource(id = R.drawable.logo), contentDescription = "", modifier = Modifier.size(22.dp))
   Icon(painter = painterResource(id = R.drawable.baseline_shopping_cart_24), contentDescription = "")
   
  }
 }

@Composable
fun CustomFilterChip(
 title: String,
 selected: Boolean,
 modifier: Modifier = Modifier,
 onValueChange: (String) -> Unit,

 ) {

 TextButton(
  onClick = { onValueChange(title) },
  shape = RoundedCornerShape(22.dp),
  elevation = ButtonDefaults.elevatedButtonElevation(0.dp),
  colors = ButtonDefaults.buttonColors(

  ),
  modifier = modifier.padding(end = 15.dp)
 ) {
  Text(
   text = title, style = TextStyle(
    color = if (selected) Color.White else Color.Black,
    fontWeight = FontWeight.W400,
    fontSize = 20.em,
    
   ),
   modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
  )
 }

}

@Preview
@Composable
fun HeaderPreview(){
 HomeScreen(rememberNavController())

}