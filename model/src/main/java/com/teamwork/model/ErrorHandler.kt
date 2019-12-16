package com.teamwork.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class ErrorHandler{

    @JsonProperty("error")
    @get:JsonProperty("error")
    @set:JsonProperty("error")
    var error: String? = null

}