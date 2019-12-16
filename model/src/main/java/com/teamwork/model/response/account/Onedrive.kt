package com.teamwork.model.response.account


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Onedrive(
    @JsonProperty("available")
    var available: Boolean?,
    @JsonProperty("connected")
    var connected: Boolean?,
    @JsonProperty("enabled")
    var enabled: Boolean?,
    @JsonProperty("folder")
    var folder: String?,
    @JsonProperty("folderId")
    var folderId: String?,
    @JsonProperty("hasAccess")
    var hasAccess: Boolean?,
    @JsonProperty("mode")
    var mode: String?
)