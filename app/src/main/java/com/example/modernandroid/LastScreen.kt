package com.example.modernandroid

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LastScreen(navController: NavController) {
    Column {
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "back")
        }
        Text(
            text = "Last!",
        )
        Spacer(modifier = Modifier.size(10.dp))
        Button(onClick = { navController.navigate(Screen.Home.route) }) {
            Text(text = "")
        }
    }
}