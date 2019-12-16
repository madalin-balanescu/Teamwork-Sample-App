package com.teamwork.model.response.projects


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Tag(
    @JsonProperty("color")
    var color: String?,
    @JsonProperty("id")
    var id: String?,
    @JsonProperty("name")
    var name: String?,
    @JsonProperty("projectId")
    var projectId: String?
)