package com.teamwork.model.response.projects


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Defaults(
    @JsonProperty("privacy")
    var privacy: String?
)