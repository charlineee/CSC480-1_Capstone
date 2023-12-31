package com.example.npsapp.models

import com.google.gson.annotations.SerializedName

data class Activities(
    @SerializedName("id"   ) var id   : String? = null,
    @SerializedName("name" ) var name : String? = null
)