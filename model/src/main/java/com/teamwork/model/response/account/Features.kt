package com.teamwork.model.response.account


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Features(
    @JsonProperty("audittrail")
    var audittrail: Boolean?,
    @JsonProperty("boxfiles")
    var boxfiles: Boolean?,
    @JsonProperty("burndownchart")
    var burndownchart: Boolean?,
    @JsonProperty("createbyemail")
    var createbyemail: Boolean?,
    @JsonProperty("customdomain")
    var customdomain: Boolean?,
    @JsonProperty("customfields")
    var customfields: Boolean?,
    @JsonProperty("customfieldsprojects")
    var customfieldsprojects: Boolean?,
    @JsonProperty("customfieldstasks")
    var customfieldstasks: Boolean?,
    @JsonProperty("disablingdirectfileuploads")
    var disablingdirectfileuploads: Boolean?,
    @JsonProperty("doceditor")
    var doceditor: Boolean?,
    @JsonProperty("dropbox")
    var dropbox: Boolean?,
    @JsonProperty("exportallprojects")
    var exportallprojects: Boolean?,
    @JsonProperty("exportsingleproject")
    var exportsingleproject: Boolean?,
    @JsonProperty("2fa")
    var fa: Boolean?,
    @JsonProperty("googlecalsync")
    var googlecalsync: Boolean?,
    @JsonProperty("googledocs")
    var googledocs: Boolean?,
    @JsonProperty("hubspot")
    var hubspot: Boolean?,
    @JsonProperty("loginhistory")
    var loginhistory: Boolean?,
    @JsonProperty("manageworkloadcapacity")
    var manageworkloadcapacity: Boolean?,
    @JsonProperty("microsoftconnector")
    var microsoftconnector: Boolean?,
    @JsonProperty("officeaddin")
    var officeaddin: Boolean?,
    @JsonProperty("officeaddinmsproject")
    var officeaddinmsproject: Boolean?,
    @JsonProperty("onedrivebusinessfiles")
    var onedrivebusinessfiles: Boolean?,
    @JsonProperty("onedrivefiles")
    var onedrivefiles: Boolean?,
    @JsonProperty("portfolio")
    var portfolio: Boolean?,
    @JsonProperty("portfolioprivacy")
    var portfolioprivacy: Boolean?,
    @JsonProperty("projecttags")
    var projecttags: Boolean?,
    @JsonProperty("projecttemplates")
    var projecttemplates: Boolean?,
    @JsonProperty("projectupdates")
    var projectupdates: Boolean?,
    @JsonProperty("riskregister")
    var riskregister: Boolean?,
    @JsonProperty("sharepoint")
    var sharepoint: Boolean?,
    @JsonProperty("shortcuts")
    var shortcuts: Boolean?,
    @JsonProperty("slack")
    var slack: Boolean?,
    @JsonProperty("sso")
    var sso: Boolean?,
    @JsonProperty("teamsbulkactions")
    var teamsbulkactions: Boolean?,
    @JsonProperty("teamscompanyteams")
    var teamscompanyteams: Boolean?,
    @JsonProperty("teamsdefaultprojects")
    var teamsdefaultprojects: Boolean?,
    @JsonProperty("teamsprojectteams")
    var teamsprojectteams: Boolean?,
    @JsonProperty("teamssubteams")
    var teamssubteams: Boolean?,
    @JsonProperty("viewworkloadcapacity")
    var viewworkloadcapacity: Boolean?,
    @JsonProperty("webhooks")
    var webhooks: Boolean?,
    @JsonProperty("workloadplanner")
    var workloadplanner: Boolean?,
    @JsonProperty("yoxelsync")
    var yoxelsync: Boolean?
)