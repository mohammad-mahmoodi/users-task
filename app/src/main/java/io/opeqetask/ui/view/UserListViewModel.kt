package io.opeqetask.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.opeqetask.model.User
import io.opeqetask.remote.model.Resource
import io.opeqetask.repository.UserRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val users: MutableLiveData<Resource<List<User?>>> by lazy {
        MutableLiveData()
    }
    val usersLiveData: LiveData<Resource<List<User?>>> = users
    fun getUsers() {
        viewModelScope.launch {
            userRepository.getUsers().collect {
                users.postValue(Resource.Success(it))
            }
        }
    }

}