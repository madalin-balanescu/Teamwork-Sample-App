package com.teamwork.model.response.projects


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Xero(
    @JsonProperty("basecurrency")
    var basecurrency: String?,
    @JsonProperty("connected")
    var connected: String?,
    @JsonProperty("countrycode")
    var countrycode: String?,
    @JsonProperty("enabled")
    var enabled: Boolean?,
    @JsonProperty("organisation")
    var organisation: String?
)