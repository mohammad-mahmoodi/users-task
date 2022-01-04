package io.opeqetask.remote.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class UserDataResponse(
    @SerializedName("info")
    var info: Info? = null,
    @SerializedName("results")
    var results: List<Result?>? = null
) {
    @Keep
    data class Info(
        @SerializedName("page")
        var page: Int? = null,
        @SerializedName("results")
        var results: Int? = null,
        @SerializedName("seed")
        var seed: String? = null,
        @SerializedName("version")
        var version: String? = null
    )

    @Keep
    data class Result(
        @SerializedName("cell")
        var cell: String? = null,
        @SerializedName("dob")
        var dob: Dob? = null,
        @SerializedName("email")
        var email: String? = null,
        @SerializedName("gender")
        var gender: String? = null,
        @SerializedName("id")
        var id: Id? = null,
        @SerializedName("location")
        var location: Location? = null,
        @SerializedName("login")
        var login: Login? = null,
        @SerializedName("name")
        var name: Name? = null,
        @SerializedName("nat")
        var nat: String? = null,
        @SerializedName("phone")
        var phone: String? = null,
        @SerializedName("picture")
        var picture: Picture? = null,
        @SerializedName("registered")
        var registered: Registered? = null
    ) {
        @Keep
        data class Dob(
            @SerializedName("age")
            var age: Int? = null,
            @SerializedName("date")
            var date: String? = null
        )

        @Keep
        data class Id(
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("value")
            var value: Any? = null
        )

        @Keep
        data class Location(
            @SerializedName("city")
            var city: String? = null,
            @SerializedName("coordinates")
            var coordinates: Coordinates? = null,
            @SerializedName("country")
            var country: String? = null,
            @SerializedName("postcode")
            var postcode: Int? = null,
            @SerializedName("state")
            var state: String? = null,
            @SerializedName("street")
            var street: Street? = null,
            @SerializedName("timezone")
            var timezone: Timezone? = null
        ) {
            @Keep
            data class Coordinates(
                @SerializedName("latitude")
                var latitude: String? = null,
                @SerializedName("longitude")
                var longitude: String? = null
            )

            @Keep
            data class Street(
                @SerializedName("name")
                var name: String? = null,
                @SerializedName("number")
                var number: Int? = null
            )

            @Keep
            data class Timezone(
                @SerializedName("description")
                var description: String? = null,
                @SerializedName("offset")
                var offset: String? = null
            )
        }

        @Keep
        data class Login(
            @SerializedName("md5")
            var md5: String? = null,
            @SerializedName("password")
            var password: String? = null,
            @SerializedName("salt")
            var salt: String? = null,
            @SerializedName("sha1")
            var sha1: String? = null,
            @SerializedName("sha256")
            var sha256: String? = null,
            @SerializedName("username")
            var username: String? = null,
            @SerializedName("uuid")
            var uuid: String? = null
        )

        @Keep
        data class Name(
            @SerializedName("first")
            var first: String? = null,
            @SerializedName("last")
            var last: String? = null,
            @SerializedName("title")
            var title: String? = null
        )

        @Keep
        data class Picture(
            @SerializedName("large")
            var large: String? = null,
            @SerializedName("medium")
            var medium: String? = null,
            @SerializedName("thumbnail")
            var thumbnail: String? = null
        )

        @Keep
        data class Registered(
            @SerializedName("age")
            var age: Int? = null,
            @SerializedName("date")
            var date: String? = null
        )
    }
}