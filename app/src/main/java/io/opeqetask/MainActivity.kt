package io.opeqetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.opeqetask.ui.theme.OpeqeTaskTheme
import io.opeqetask.ui.view.userList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpeqeTaskTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "user-list") {
                    composable("user-list") { userList() }
//                    composable("friendslist") { FriendsList(/*...*/) }
                    /*...*/
                }
            }
        }
    }
}