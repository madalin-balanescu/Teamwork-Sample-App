package com.teamwork.model.response.projects


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class AllProjectsResponse(
    @JsonProperty("projects")
    var projects: List<Project?>?,
    @JsonProperty("STATUS")
    var sTATUS: String?
)