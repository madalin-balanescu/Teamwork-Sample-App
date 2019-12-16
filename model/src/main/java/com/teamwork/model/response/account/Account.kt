package com.teamwork.model.response.account


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Account(
    @JsonProperty("account-holder-id")
    var accountHolderId: String?,
    @JsonProperty("allowKeepMeLoggedIn")
    var allowKeepMeLoggedIn: Boolean?,
    @JsonProperty("allowProjectAdminsCreateUsers")
    var allowProjectAdminsCreateUsers: Boolean?,
    @JsonProperty("allowTeamworkProjectsBrand")
    var allowTeamworkProjectsBrand: Boolean?,
    @JsonProperty("autoProvisionUsers")
    var autoProvisionUsers: Boolean?,
    @JsonProperty("awsRegion")
    var awsRegion: String?,
    @JsonProperty("betaFeatures")
    var betaFeatures: BetaFeatures?,
    @JsonProperty("betaFeaturesEnabled")
    var betaFeaturesEnabled: Boolean?,
    @JsonProperty("billingAmount")
    var billingAmount: String?,
    @JsonProperty("billingPeriod")
    var billingPeriod: String?,
    @JsonProperty("CRMEnabled")
    var cRMEnabled: Boolean?,
    @JsonProperty("cacheUUID")
    var cacheUUID: String?,
    @JsonProperty("canEditCustomDomain")
    var canEditCustomDomain: Boolean?,
    @JsonProperty("canPreviewFiles")
    var canPreviewFiles: Boolean?,
    @JsonProperty("canShareFiles")
    var canShareFiles: Boolean?,
    @JsonProperty("canUploadFilesDirectly")
    var canUploadFilesDirectly: Boolean?,
    @JsonProperty("chatEnabled")
    var chatEnabled: Boolean?,
    @JsonProperty("cleanNotebooksOnPaste")
    var cleanNotebooksOnPaste: Boolean?,
    @JsonProperty("code")
    var code: String?,
    @JsonProperty("companyIndustryCategoryId")
    var companyIndustryCategoryId: String?,
    @JsonProperty("companyIndustryCategoryName")
    var companyIndustryCategoryName: String?,
    @JsonProperty("companyid")
    var companyid: String?,
    @JsonProperty("companyname")
    var companyname: String?,
    @JsonProperty("corsEnabled")
    var corsEnabled: Boolean?,
    @JsonProperty("created-at")
    var createdAt: String?,
    @JsonProperty("csrfEnabled")
    var csrfEnabled: Boolean?,
    @JsonProperty("customCSS")
    var customCSS: String?,
    @JsonProperty("customCSSAvailable")
    var customCSSAvailable: Boolean?,
    @JsonProperty("customCSSEnabled")
    var customCSSEnabled: Boolean?,
    @JsonProperty("dashboardMessage")
    var dashboardMessage: String?,
    @JsonProperty("dashboardMessageHTML")
    var dashboardMessageHTML: String?,
    @JsonProperty("dashboardProjectsList")
    var dashboardProjectsList: String?,
    @JsonProperty("datesignedup")
    var datesignedup: String?,
    @JsonProperty("defaultUserType")
    var defaultUserType: String?,
    @JsonProperty("deskEnabled")
    var deskEnabled: Boolean?,
    @JsonProperty("documentEditorAvailable")
    var documentEditorAvailable: Boolean?,
    @JsonProperty("documentEditorEnabled")
    var documentEditorEnabled: Boolean?,
    @JsonProperty("email-notification-enabled")
    var emailNotificationEnabled: Boolean?,
    @JsonProperty("favIcon")
    var favIcon: String?,
    @JsonProperty("id")
    var id: String?,
    @JsonProperty("inGracePeriod")
    var inGracePeriod: Boolean?,
    @JsonProperty("installationIsTestAccount")
    var installationIsTestAccount: Boolean?,
    @JsonProperty("integrations")
    var integrations: Integrations?,
    @JsonProperty("isAdmin")
    var isAdmin: Boolean?,
    @JsonProperty("isLiveChatEnabled")
    var isLiveChatEnabled: Boolean?,
    @JsonProperty("isPaid")
    var isPaid: String?,
    @JsonProperty("lang")
    var lang: String?,
    @JsonProperty("lifetimeValue")
    var lifetimeValue: String?,
    @JsonProperty("likesEnabled")
    var likesEnabled: Boolean?,
    @JsonProperty("logo")
    var logo: String?,
    @JsonProperty("markdownEnabled")
    var markdownEnabled: Boolean?,
    @JsonProperty("memberOfOwnerCompany")
    var memberOfOwnerCompany: String?,
    @JsonProperty("name")
    var name: String?,
    @JsonProperty("notebooksNewlineMode")
    var notebooksNewlineMode: Boolean?,
    @JsonProperty("officeAddinAvailable")
    var officeAddinAvailable: Boolean?,
    @JsonProperty("officeAddinMSProjectAvailable")
    var officeAddinMSProjectAvailable: Boolean?,
    @JsonProperty("onTeamworkDomain")
    var onTeamworkDomain: Boolean?,
    @JsonProperty("paidForUsers")
    var paidForUsers: String?,
    @JsonProperty("paidUntilDateTime")
    var paidUntilDateTime: String?,
    @JsonProperty("passwordPolicyIsOn")
    var passwordPolicyIsOn: Boolean?,
    @JsonProperty("paymentMethod")
    var paymentMethod: String?,
    @JsonProperty("paymentStatus")
    var paymentStatus: String?,
    @JsonProperty("pdfServerLink")
    var pdfServerLink: String?,
    @JsonProperty("portfolioEnabled")
    var portfolioEnabled: Boolean?,
    @JsonProperty("pricePlan")
    var pricePlan: String?,
    @JsonProperty("pricePlanId")
    var pricePlanId: String?,
    @JsonProperty("pricePlanName")
    var pricePlanName: String?,
    @JsonProperty("priceplanAllowSSL")
    var priceplanAllowSSL: Boolean?,
    @JsonProperty("priceplanCanTurnOffTWBranding")
    var priceplanCanTurnOffTWBranding: Boolean?,
    @JsonProperty("priceplanData")
    var priceplanData: PriceplanData?,
    @JsonProperty("priceplanMaxUsers")
    var priceplanMaxUsers: String?,
    @JsonProperty("priceplanType")
    var priceplanType: String?,
    @JsonProperty("projectsEnabled")
    var projectsEnabled: Boolean?,
    @JsonProperty("projectsNextBillingDate")
    var projectsNextBillingDate: String?,
    @JsonProperty("RSSEnabled")
    var rSSEnabled: Boolean?,
    @JsonProperty("realTimeNotifications")
    var realTimeNotifications: Boolean?,
    @JsonProperty("requirehttps")
    var requirehttps: Boolean?,
    @JsonProperty("SSO")
    var sSO: SSO?,
    @JsonProperty("sessionTimeoutEnabled")
    var sessionTimeoutEnabled: Boolean?,
    @JsonProperty("shardNo")
    var shardNo: String?,
    @JsonProperty("shortcutsAvailable")
    var shortcutsAvailable: Boolean?,
    @JsonProperty("showSiteNameOnLogin")
    var showSiteNameOnLogin: Boolean?,
    @JsonProperty("showSwitchToDotCom")
    var showSwitchToDotCom: Boolean?,
    @JsonProperty("siteOwnerEmail")
    var siteOwnerEmail: String?,
    @JsonProperty("siteOwnerName")
    var siteOwnerName: String?,
    @JsonProperty("spacesEnabled")
    var spacesEnabled: Boolean?,
    @JsonProperty("sslCustomProxy")
    var sslCustomProxy: String?,
    @JsonProperty("ssl-enabled")
    var sslEnabled: Boolean?,
    @JsonProperty("strictBranding")
    var strictBranding: Boolean?,
    @JsonProperty("TKOEnabled")
    var tKOEnabled: Boolean?,
    @JsonProperty("tagsEnabled")
    var tagsEnabled: Boolean?,
    @JsonProperty("tagsLockedToAdmins")
    var tagsLockedToAdmins: Boolean?,
    @JsonProperty("tasklistTemplateProjectId")
    var tasklistTemplateProjectId: String?,
    @JsonProperty("time-tracking-enabled")
    var timeTrackingEnabled: Boolean?,
    @JsonProperty("touchIcon")
    var touchIcon: String?,
    @JsonProperty("trialDaysRemaining")
    var trialDaysRemaining: String?,
    @JsonProperty("trialExpiryDate")
    var trialExpiryDate: String?,
    @JsonProperty("twUsernamePasswordEnabled")
    var twUsernamePasswordEnabled: Boolean?,
    @JsonProperty("URL")
    var uRL: String?,
    @JsonProperty("userIsAdmin")
    var userIsAdmin: Boolean?,
    @JsonProperty("webhooksEnabled")
    var webhooksEnabled: Boolean?
)