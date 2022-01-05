package io.opeqetask.ui.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import io.opeqetask.remote.model.Resource

@Composable
fun userList( userListViewModel: UserListViewModel = hiltViewModel()){
    LaunchedEffect(Unit) {
        userListViewModel.getUsers()
    }
    val userState = userListViewModel.usersLiveData.observeAsState().value
    when(userState) {
        is Resource.Success -> {
            LazyColumn {
                items(count =  userState.data?.size ?: 0 ,
                ) {
                    Text("Item is ${userState.data?.get(it)}")
                }
            }

        }
    }
}