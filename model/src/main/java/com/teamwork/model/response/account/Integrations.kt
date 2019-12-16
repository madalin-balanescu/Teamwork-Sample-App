package com.teamwork.model.response.account


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Integrations(
    @JsonProperty("clockInOut")
    var clockInOut: ClockInOut?,
    @JsonProperty("hubSpot")
    var hubSpot: HubSpot?,
    @JsonProperty("microsoftConnectors")
    var microsoftConnectors: MicrosoftConnectors?,
    @JsonProperty("onedrive")
    var onedrive: Onedrive?,
    @JsonProperty("onedrivebusiness")
    var onedrivebusiness: Onedrivebusiness?,
    @JsonProperty("sharepoint")
    var sharepoint: Sharepoint?,
    @JsonProperty("yoxelSync")
    var yoxelSync: YoxelSync?
)