package com.example.npsapp.models

import com.google.gson.annotations.SerializedName

data class EntranceFees (
    @SerializedName("cost"        ) var cost        : String? = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("title"       ) var title       : String? = null
)