package com.example.npsapp.models

import com.google.gson.annotations.SerializedName

data class Addresses(
    @SerializedName("postalCode" ) var postalCode : String? = null,
    @SerializedName("city"       ) var city       : String? = null,
    @SerializedName("stateCode"  ) var stateCode  : String? = null,
    @SerializedName("line1"      ) var line1      : String? = null,
    @SerializedName("type"       ) var type       : String? = null,
    @SerializedName("line3"      ) var line3      : String? = null,
    @SerializedName("line2"      ) var line2      : String? = null
)
