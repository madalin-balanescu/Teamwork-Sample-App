package com.teamwork.model.response.account


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class PriceplanData(
    @JsonProperty("code")
    var code: String?,
    @JsonProperty("features")
    var features: Features?,
    @JsonProperty("id")
    var id: String?,
    @JsonProperty("name")
    var name: String?,
    @JsonProperty("trials")
    var trials: Trials?,
    @JsonProperty("type")
    var type: String?
)