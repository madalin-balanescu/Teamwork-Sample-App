package com.teamwork.model.response.account


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class AccountResponse(
    @JsonProperty("account")
    var account: Account?,
    @JsonProperty("STATUS")
    var sTATUS: String?
)