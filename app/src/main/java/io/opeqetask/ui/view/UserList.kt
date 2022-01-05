package io.opeqetask.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import io.opeqetask.model.User
import io.opeqetask.remote.model.Resource

@Composable
fun userListScreen(
    navController: NavController,
    userListViewModel: UserListViewModel = hiltViewModel()
) {

    val userBackStackEntry = remember { navController.getBackStackEntry("user-list") }
    val userListViewModel: UserListViewModel = hiltViewModel(userBackStackEntry)


    LaunchedEffect(Unit) {
        userListViewModel.getUsers()
    }
    val userState = userListViewModel.usersLiveData.observeAsState().value
    when (userState) {
        is Resource.Success -> {
            LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
                items(
                    count = userState.data?.size ?: 0,
                ) {
                    UserContent(userState.data?.get(it), navController)
                }
            }

        }

        is Resource.Loading -> {
            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }

        is Resource.Error -> {
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .fillMaxHeight()
            ) {

            }
            Snackbar(
                modifier = Modifier.padding(8.dp),
                action = {
                    Button(onClick = { userListViewModel.getUsers() }) {
                        Text(text = "retry")
                    }
                }) {

                Text(text = userState.error ?: "")
            }

        }
    }
}


@Composable
fun UserContent(
    user: User?, navController: NavController?,
    userListViewModel: UserListViewModel = hiltViewModel()
) {
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .clickable {
            userListViewModel.selectedUser = user
            navController?.navigate("user-details")
        }

    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
            Image(
                painter = rememberImagePainter(
                    data = user?.imageUrl,
                    builder = {
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(2.dp)
            )

            Column(Modifier.padding(start = 10.dp)) {
                Text("${user?.name}")
                Text(text = "${user?.address}", fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}

@Preview
@Composable
fun ComposablePreview() {
    UserContent(User("test", "test", "test"), null)
}



