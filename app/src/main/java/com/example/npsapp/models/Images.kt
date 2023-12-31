package com.example.npsapp.models

import com.google.gson.annotations.SerializedName

data class Images (
    @SerializedName("credit"  ) var credit  : String? = null,
    @SerializedName("title"   ) var title   : String? = null,
    @SerializedName("altText" ) var altText : String? = null,
    @SerializedName("caption" ) var caption : String? = null,
    @SerializedName("url"     ) var url     : String? = null
)