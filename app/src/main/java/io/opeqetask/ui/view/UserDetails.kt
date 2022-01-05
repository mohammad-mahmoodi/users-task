package io.opeqetask.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation

@Composable
fun UserDetailsScreen(
    navController: NavHostController
){

    val userBackStackEntry = remember { navController.getBackStackEntry("user-list") }
    val userListViewModel: UserListViewModel = hiltViewModel(userBackStackEntry)

    val user=  userListViewModel.selectedUser
    Column() {
        Image(
            painter = rememberImagePainter(
                data = user?.imageUrl,
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
        )

        Text(user?.name ?:"")
        Text(user?.address ?: "")
    }

}