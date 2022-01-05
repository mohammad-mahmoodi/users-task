package io.opeqetask.repository

import io.opeqetask.remote.RemoteDateSource
import io.opeqetask.remote.model.UserDataResponse
import io.opeqetask.remote.model.toUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val remoteDateSource: RemoteDateSource,
) {

    fun getUsers() = remoteDateSource.getUser().map {
        it.results?.map { result -> result?.toUser() }
    }


}