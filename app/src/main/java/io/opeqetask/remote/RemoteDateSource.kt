package io.opeqetask.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDateSource @Inject constructor(
    private val apiService: ApiService,
) {
   fun getUser( count : Int? = 10) = flow {
       emit(apiService.getUser(count))
   }.flowOn(Dispatchers.IO)

}