package com.teamwork.model.response.projects


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Company(
    @JsonProperty("id")
    var id: String?,
    @JsonProperty("is-owner")
    var isOwner: String?,
    @JsonProperty("name")
    var name: String?
)