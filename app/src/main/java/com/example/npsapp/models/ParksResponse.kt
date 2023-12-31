package com.example.npsapp.models

import com.google.gson.annotations.SerializedName

data class ParksResponse(
    @SerializedName("total" ) var total : String?         = null,
    @SerializedName("limit" ) var limit : String?         = null,
    @SerializedName("start" ) var start : String?         = null,
    @SerializedName("data"  ) var data  : List<Datum>?    = null,
)