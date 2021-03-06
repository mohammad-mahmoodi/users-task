package io.opeqetask.model

import io.opeqetask.remote.model.UserDataResponse

data class User(
    var name: String? ,
    var imageUrl : String? ,
    var imageLargeUrl : String? ,
    var address : String?,
    var phoneNumber : String?,
    var email : String?,
)
