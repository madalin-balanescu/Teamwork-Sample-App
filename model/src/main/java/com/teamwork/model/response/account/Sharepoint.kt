package com.teamwork.model.response.account


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Sharepoint(
    @JsonProperty("available")
    var available: Boolean?,
    @JsonProperty("enabled")
    var enabled: Boolean?
)