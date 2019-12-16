package com.teamwork.model.response.projects


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Project(
    @JsonProperty("announcement")
    var announcement: String?,
    @JsonProperty("announcementHTML")
    var announcementHTML: String?,
    @JsonProperty("boardData")
    var boardData: BoardData?,
    @JsonProperty("category")
    var category: Category?,
    @JsonProperty("company")
    var company: Company?,
    @JsonProperty("created-on")
    var createdOn: String?,
    @JsonProperty("defaultPrivacy")
    var defaultPrivacy: String?,
    @JsonProperty("defaults")
    var defaults: Defaults?,
    @JsonProperty("description")
    var description: String?,
    @JsonProperty("endDate")
    var endDate: String?,
    @JsonProperty("filesAutoNewVersion")
    var filesAutoNewVersion: Boolean?,
    @JsonProperty("harvest-timers-enabled")
    var harvestTimersEnabled: Boolean?,
    @JsonProperty("id")
    var id: String?,
    @JsonProperty("integrations")
    var integrations: Integrations?,
    @JsonProperty("isOnBoardingProject")
    var isOnBoardingProject: Boolean?,
    @JsonProperty("isProjectAdmin")
    var isProjectAdmin: Boolean?,
    @JsonProperty("isSampleProject")
    var isSampleProject: Boolean?,
    @JsonProperty("last-changed-on")
    var lastChangedOn: String?,
    @JsonProperty("lastWorkedOn")
    var lastWorkedOn: String?,
    @JsonProperty("logo")
    var logo: String?,
    @JsonProperty("name")
    var name: String?,
    @JsonProperty("notifyeveryone")
    var notifyeveryone: Boolean?,
    @JsonProperty("overview-start-page")
    var overviewStartPage: String?,
    @JsonProperty("portfolioBoards")
    var portfolioBoards: List<Any?>?,
    @JsonProperty("privacyEnabled")
    var privacyEnabled: Boolean?,
    @JsonProperty("replyByEmailEnabled")
    var replyByEmailEnabled: Boolean?,
    @JsonProperty("show-announcement")
    var showAnnouncement: Boolean?,
    @JsonProperty("starred")
    var starred: Boolean?,
    @JsonProperty("startDate")
    var startDate: String?,
    @JsonProperty("start-page")
    var startPage: String?,
    @JsonProperty("status")
    var status: String?,
    @JsonProperty("subStatus")
    var subStatus: String?,
    @JsonProperty("tags")
    var tags: List<Tag?>?,
    @JsonProperty("tasks-start-page")
    var tasksStartPage: String?
)