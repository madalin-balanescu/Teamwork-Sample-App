package com.teamwork.model.response.projects


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Onedrivebusiness(
    @JsonProperty("account")
    var account: String?,
    @JsonProperty("enabled")
    var enabled: Boolean?,
    @JsonProperty("folder")
    var folder: String?,
    @JsonProperty("foldername")
    var foldername: String?
)