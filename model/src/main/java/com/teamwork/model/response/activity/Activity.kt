package com.teamwork.model.response.activity


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Activity(
    @JsonProperty("activitytype")
    var activitytype: String?,
    @JsonProperty("company-id")
    var companyId: String?,
    @JsonProperty("company-name")
    var companyName: String?,
    @JsonProperty("datetime")
    var datetime: String?,
    @JsonProperty("description")
    var description: String?,
    @JsonProperty("due-date")
    var dueDate: String?,
    @JsonProperty("extradescription")
    var extradescription: String?,
    @JsonProperty("for-user-avatar-url")
    var forUserAvatarUrl: String?,
    @JsonProperty("foruserid")
    var foruserid: String?,
    @JsonProperty("forusername")
    var forusername: String?,
    @JsonProperty("from-user-avatar-url")
    var fromUserAvatarUrl: String?,
    @JsonProperty("fromusername")
    var fromusername: String?,
    @JsonProperty("id")
    var id: String?,
    @JsonProperty("isprivate")
    var isprivate: String?,
    @JsonProperty("itemid")
    var itemid: String?,
    @JsonProperty("itemlink")
    var itemlink: String?,
    @JsonProperty("latestActivityType")
    var latestActivityType: String?,
    @JsonProperty("link")
    var link: String?,
    @JsonProperty("lockdownId")
    var lockdownId: String?,
    @JsonProperty("project-id")
    var projectId: String?,
    @JsonProperty("project-name")
    var projectName: String?,
    @JsonProperty("publicinfo")
    var publicinfo: String?,
    @JsonProperty("type")
    var type: String?,
    @JsonProperty("userid")
    var userid: String?
)