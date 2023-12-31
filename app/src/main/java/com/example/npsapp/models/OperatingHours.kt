package com.example.npsapp.models

import com.google.gson.annotations.SerializedName

data class OperatingHours(
    @SerializedName("description"   ) var description   : String?               = null,
    @SerializedName("name"          ) var name          : String?               = null
)