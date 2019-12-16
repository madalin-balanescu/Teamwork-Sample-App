package com.teamwork.model.response.projects


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Integrations(
    @JsonProperty("microsoftConnectors")
    var microsoftConnectors: MicrosoftConnectors?,
    @JsonProperty("onedrivebusiness")
    var onedrivebusiness: Onedrivebusiness?,
    @JsonProperty("sharepoint")
    var sharepoint: Sharepoint?,
    @JsonProperty("xero")
    var xero: Xero?
)