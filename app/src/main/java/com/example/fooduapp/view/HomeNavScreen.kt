package com.example.fooduapp.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.Store
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.NoteAlt
import androidx.compose.material.icons.outlined.Percent
import androidx.compose.material.icons.outlined.Store
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fooduapp.HOME_SCREEN
import com.example.fooduapp.ORDER_SCREEN
import com.example.fooduapp.PROMOTION_SCREEN
import com.example.fooduapp.RESTAURANT_SCREEN

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

@Composable
fun HomeNavScreen(
    modifier: Modifier = Modifier
) {
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        BottomNavigationItem(
            title = "Promotion",
            selectedIcon = Icons.Filled.Percent,
            unselectedIcon = Icons.Outlined.Percent
        ),
        BottomNavigationItem(
            title = "Restaurant",
            selectedIcon = Icons.Filled.Store,
            unselectedIcon = Icons.Outlined.Store
        ),
        BottomNavigationItem(
            title = "Order",
            selectedIcon = Icons.Filled.NoteAlt,
            unselectedIcon = Icons.Outlined.NoteAlt
        )
    )
    val rootNavController = rememberNavController()
    val navBackStackEntry by rootNavController.currentBackStackEntryAsState()
    Scaffold (
        bottomBar = {
            NavigationBar {
                items.forEach{item ->
                    val isSelected = "${item.title}Screen" == navBackStackEntry?.destination?.route
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            rootNavController.navigate("${item.title}Screen") {
                                popUpTo(rootNavController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(text = item.title) },
                        icon = {
                            Icon(
                                imageVector = if(isSelected) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = rootNavController,
            startDestination = HOME_SCREEN,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = HOME_SCREEN) {
                HomeScreen()
            }
            composable(route = PROMOTION_SCREEN) {
                PromotionScreen()
            }
            composable(route = RESTAURANT_SCREEN) {
                RestaurantScreen()
            }
            composable(route = ORDER_SCREEN) {
                OrderScreen()
            }
        }
    }
}
