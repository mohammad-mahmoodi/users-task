package io.opeqetask.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.opeqetask.model.User
import io.opeqetask.remote.model.Resource
import io.opeqetask.repository.UserRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    var selectedUser: User? = null
    private val users: MutableLiveData<Resource<List<User?>>> by lazy {
        MutableLiveData()
    }
    val usersLiveData: LiveData<Resource<List<User?>>> = users
    fun getUsers() {
        viewModelScope.launch {
            users.postValue(Resource.Loading)
            userRepository.getUsers()
                .catch { users.postValue(Resource.Error("ops !!!")) }
                .collect {
                users.postValue(Resource.Success(it))
            }
        }
    }

}