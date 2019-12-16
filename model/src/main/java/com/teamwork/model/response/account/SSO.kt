package com.teamwork.model.response.account


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SSO(
    @JsonProperty("available")
    var available: Boolean?
)