package com.example.npsapp.util

import com.example.npsapp.BuildConfig

object Constants {
    const val BASE_URL = "https://developer.nps.gov/api/"

    const val API_KEY = BuildConfig.NPS_API_KEY

    val statesMap: HashMap<String, String> = linkedMapOf(
        "Alabama" to "AL", "Alaska" to "AK", "Arizona" to "AZ", "Arkansas" to "AR",
        "California" to "CA", "Colorado" to "CO", "Connecticut" to "CT", "Delaware" to "DE",
        "District of Columbia" to "DC", "Florida" to "FL", "Georgia" to "GA", "Hawaii" to "HI",
        "Idaho" to "ID", "Illinois" to "IL", "Indiana" to "IN", "Iowa" to "IA", "Kansas" to "KS",
        "Kentucky" to "KY", "Louisiana" to "LA", "Maine" to "ME", "Maryland" to "MD",
        "Massachusetts" to "MA", "Michigan" to "MI", "Minnesota" to "MN", "Mississippi" to "MS",
        "Missouri" to "MO", "Montana" to "MT", "Nebraska" to "NE", "Nevada" to "NV",
        "New Hampshire" to "NH", "New Jersey" to "NJ", "New Mexico" to "NM", "New York" to "NY",
        "North Carolina" to "NC", "North Dakota" to "ND", "Ohio" to "OH", "Oklahoma" to "OK",
        "Oregon" to "OR", "Pennsylvania" to "PA", "Rhode Island" to "RI",
        "South Carolina" to "SC", "South Dakota" to "SD", "Tennessee" to "TN", "Texas" to "TX",
        "Utah" to "UT", "Vermont" to "VT", "Virgina" to "VA", "Washington" to "WA",
        "West Virginia" to "WV", "Wisconsin" to "WI", "Wyoming" to "WY")

    val activityMap: HashMap<String, String> = linkedMapOf(
        "Biking" to "7CE6E935-F839-4FEC-A63E-052B1DEF39D2",
        "Camping" to "A59947B7-3376-49B4-AD02-C0423E08C5F7",
        "Climbing" to "B12FAAB9-713F-4B38-83E4-A273F5A43C77",
        "Fishing" to "AE42B46C-E4B7-4889-A122-08FE180371AE",
        "Hiking" to "BFF8C027-7C8F-480B-A5F8-CD8CE490BFBA",
        "Skiing" to "F9B1D433-6B86-4804-AED7-B50A519A3B7C",
        "Stargazing" to "13A57703-BB1A-41A2-94B8-53B692EB7238",
        "Swimming" to "587BB2D3-EC35-41B2-B3F7-A39E2B088AEE")
}


