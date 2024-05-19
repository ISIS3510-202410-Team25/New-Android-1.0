package com.example.fooduapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.fooduapp.view.FoodUNavigation
import com.example.fooduapp.ui.theme.FoodUAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodUApp()
        }
    }
}

@Composable
fun FoodUApp() {
    FoodUAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            FoodUNavigation()
        }
    }
}