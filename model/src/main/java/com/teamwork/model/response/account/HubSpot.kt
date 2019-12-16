package com.teamwork.model.response.account


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class HubSpot(
    @JsonProperty("available")
    var available: String?,
    @JsonProperty("enabled")
    var enabled: Boolean?,
    @JsonProperty("portalId")
    var portalId: String?
)