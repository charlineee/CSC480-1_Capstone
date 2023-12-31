package com.example.npsapp.models

import com.google.gson.annotations.SerializedName

data class Datum(
    @SerializedName("id"             ) var id             : String?                   = null,
    @SerializedName("url"            ) var url            : String?                   = null,
    @SerializedName("fullName"       ) var fullName       : String?                   = null,
    @SerializedName("parkCode"       ) var parkCode       : String?                   = null,
    @SerializedName("description"    ) var description    : String?                   = null,
    @SerializedName("latitude"       ) var latitude       : String?                   = null,
    @SerializedName("longitude"      ) var longitude      : String?                   = null,
    @SerializedName("latLong"        ) var latLong        : String?                   = null,
    @SerializedName("activities"     ) var activities     : ArrayList<Activities>     = arrayListOf(),
    @SerializedName("states"         ) var states         : String?                   = null,
    @SerializedName("entranceFees"   ) var entranceFees   : ArrayList<EntranceFees>   = arrayListOf(),
    @SerializedName("fees"           ) var fees           : ArrayList<String>         = arrayListOf(),
    @SerializedName("directionsInfo" ) var directionsInfo : String?                   = null,
    @SerializedName("directionsUrl"  ) var directionsUrl  : String?                   = null,
    @SerializedName("operatingHours" ) var operatingHours : ArrayList<OperatingHours> = arrayListOf(),
    @SerializedName("addresses"      ) var addresses      : ArrayList<Addresses>      = arrayListOf(),
    @SerializedName("images"         ) var images         : ArrayList<Images>         = arrayListOf(),
    @SerializedName("weatherInfo"    ) var weatherInfo    : String?                   = null,
    @SerializedName("name"           ) var name           : String?                   = null,
    @SerializedName("designation"    ) var designation    : String?                   = null
)
