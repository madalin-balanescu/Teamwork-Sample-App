package com.teamwork.model.response.activity


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class LatestActivityResponse(
    @JsonProperty("activity")
    var activity: List<Activity?>?,
    @JsonProperty("STATUS")
    var sTATUS: String?
)