package io.opeqetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.opeqetask.ui.theme.OpeqeTaskTheme
import io.opeqetask.ui.view.UserDetailsScreen
import io.opeqetask.ui.view.UserListViewModel
import io.opeqetask.ui.view.userListScreen
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpeqeTaskTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "user-list") {
                    composable("user-list") {
                        userListScreen(navController )
                    }
                    composable("user-details") {
                        UserDetailsScreen(navController)
                    }
                    /*...*/
                }
            }
        }
    }
}