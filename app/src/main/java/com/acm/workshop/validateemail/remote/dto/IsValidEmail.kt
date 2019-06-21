package com.acm.workshop.validateemail.remote.dto

import com.google.gson.annotations.SerializedName


data class IsValidEmail(
    @SerializedName("isValid") val isValid: Boolean?
)