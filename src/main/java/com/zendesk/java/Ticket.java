package com.zendesk.java;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

//@JsonIgnoreProperties({"collaborators", "custom_fields", "email_cc_ids",
//"follower_ids", "followup_ids", "macro_ids", "sharing_agreement_ids", "tags"})
public class Ticket {
    private boolean allowAttachments;
    private boolean allowChannelBack;
    private long assigneeId;
    private long brandId;
    private long[] collaboratorIds;
    private Object[] collaborators;
    private String createdAt;
    private Object customFields;
    private String description;
    private String dueAt;
    private Object[] emailCCIds;
    private String externalId;
    private long[] followerIds;
    private long[] followupIds;
    private long forumTopicId;
    private long groupId;
    private boolean hasIncidents;
    private long id;
    private boolean isPublic;
    private long[] macroIds;
    private long organizationId;
    private String priority;
    private long problemId;
    private String rawSubject;
    private String recipient;
    private long requesterId;
    private Object satisfactionRating;
    private long[] sharingAgreementIds;
    private String status;
    private String subject;
    private long submitterId;
    private List<String> tags;
    private long ticketFormId;
    private String type;
    private String updatedAt;
    private String url;
    private Object via;
    private long viaFollowupSourceId;

    public Ticket() {}

    @JsonCreator
    public Ticket(@JsonProperty("allow_attachments") boolean allowAttachments,
                  @JsonProperty("allow_channelback") boolean allowChannelBack,
                  @JsonProperty("assignee_id") long assigneeId,
                  @JsonProperty("brand_id") long brandId,
                  @JsonProperty("collaborator_ids") long[] collaboratorIds,
                  @JsonProperty("collaborators") Object[] collaborators,
                  @JsonProperty("created_at") String createdAt,
                  @JsonProperty("custom_fields") Object customFields,
                  @JsonProperty("description") String description,
                  @JsonProperty("due_at") String dueAt,
                  @JsonProperty("email_cc_ids") String[] emailCCIds,
                  @JsonProperty("external_id") String externalId,
                  @JsonProperty("follower_ids") long[] followerIds,
                  @JsonProperty("followup_ids") long[] followupIds,
                  @JsonProperty("forum_topic_id") long forumTopicId,
                  @JsonProperty("group_id") long groupId,
                  @JsonProperty("has_incidents") boolean hasIncidents,
                  @JsonProperty("id") long id,
                  @JsonProperty("is_public") boolean isPublic,
                  @JsonProperty("macro_ids") long[] macroIds,
                  @JsonProperty("organization_id") long organizationId,
                  @JsonProperty("priority") String priority,
                  @JsonProperty("problem_id") long problemId,
                  @JsonProperty("raw_subject") String rawSubject,
                  @JsonProperty("recipient") String recipient,
                  @JsonProperty("requester_id") long requesterId,
                  @JsonProperty("satisfaction_rating") Object satisfactionRating,
                  @JsonProperty("sharing_agreement_ids") long[] sharingAgreementIds,
                  @JsonProperty("status") String status,
                  @JsonProperty("subject") String subject,
                  @JsonProperty("submitter_id") long submitterId,
                  @JsonProperty("tags") List<String> tags,
                  @JsonProperty("ticket_form_id") long ticketFormId,
                  @JsonProperty("type") String type,
                  @JsonProperty("updated_at") String updatedAt,
                  @JsonProperty("url") String url,
                  // For API - ticket endpoints this is not important
                  @JsonProperty("via") Object via,
                  @JsonProperty("via_followup_source_id") long viaFollowupSourceId
    ) {
        this.setAllowAttachments(allowAttachments);
        this.setAllowChannelBack(allowChannelBack);
        this.setAssigneeId(assigneeId);
        this.setBrandId(brandId);
        this.setCollaboratorIds(collaboratorIds);
        this.setCollaborators(collaborators);
        this.setCreatedAt(createdAt);
        this.setCustomFields(customFields);
        this.setDescription(description);
        this.setDueAt(dueAt);
        this.setEmailCCIds(emailCCIds);
        this.setExternalId(externalId);
        this.setFollowerIds(followerIds);
        this.setFollowupIds(followupIds);
        this.setForumTopicId(forumTopicId);
        this.setGroupId(groupId);
        this.setHasIncidents(hasIncidents);
        this.setId(id);
        this.setPublic(isPublic);
        this.setMacroIds(macroIds);
        this.setOrganizationId(organizationId);
        this.setPriority(priority);
        this.setProblemId(problemId);
        this.setRawSubject(rawSubject);
        this.setRecipient(recipient);
        this.setRequesterId(requesterId);
        this.setSatisfactionRating(satisfactionRating);
        this.setSharingAgreementIds(sharingAgreementIds);
        this.setStatus(status);
        this.setSubject(subject);
        this.setSubmitterId(submitterId);
        this.tags = tags;
        this.setTicketFormId(ticketFormId);
        this.setType(type);
        this.setUpdatedAt(updatedAt);
        this.setUrl(url);
        this.setVia(via);
        this.setViaFollowupSourceId(viaFollowupSourceId);
    }

	public boolean isAllowAttachments() {
		return allowAttachments;
	}

	public void setAllowAttachments(boolean allowAttachments) {
		this.allowAttachments = allowAttachments;
	}

	public boolean isAllowChannelBack() {
		return allowChannelBack;
	}

	public void setAllowChannelBack(boolean allowChannelBack) {
		this.allowChannelBack = allowChannelBack;
	}

	public long getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(long assigneeId) {
		this.assigneeId = assigneeId;
	}

	public long[] getCollaboratorIds() {
		return collaboratorIds;
	}

	public void setCollaboratorIds(long[] collaboratorIds) {
		this.collaboratorIds = collaboratorIds;
	}

	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public Object[] getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(Object[] collaborators) {
		this.collaborators = collaborators;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Object getCustomFields() {
		return customFields;
	}

	public void setCustomFields(Object customFields) {
		this.customFields = customFields;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueAt() {
		return dueAt;
	}

	public void setDueAt(String dueAt) {
		this.dueAt = dueAt;
	}

	public Object[] getEmailCCIds() {
		return emailCCIds;
	}

	public void setEmailCCIds(Object[] emailCCIds) {
		this.emailCCIds = emailCCIds;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public long[] getFollowerIds() {
		return followerIds;
	}

	public void setFollowerIds(long[] followerIds) {
		this.followerIds = followerIds;
	}

	public long[] getFollowupIds() {
		return followupIds;
	}

	public void setFollowupIds(long[] followupIds) {
		this.followupIds = followupIds;
	}

	public long getForumTopicId() {
		return forumTopicId;
	}

	public void setForumTopicId(long forumTopicId) {
		this.forumTopicId = forumTopicId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public boolean isHasIncidents() {
		return hasIncidents;
	}

	public void setHasIncidents(boolean hasIncidents) {
		this.hasIncidents = hasIncidents;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long[] getMacroIds() {
		return macroIds;
	}

	public void setMacroIds(long[] macroIds) {
		this.macroIds = macroIds;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	public long getProblemId() {
		return problemId;
	}

	public void setProblemId(long problemId) {
		this.problemId = problemId;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRawSubject() {
		return rawSubject;
	}

	public void setRawSubject(String rawSubject) {
		this.rawSubject = rawSubject;
	}

	public long getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(long requesterId) {
		this.requesterId = requesterId;
	}

	public Object getSatisfactionRating() {
		return satisfactionRating;
	}

	public void setSatisfactionRating(Object satisfactionRating) {
		this.satisfactionRating = satisfactionRating;
	}

	public long[] getSharingAgreementIds() {
		return sharingAgreementIds;
	}

	public void setSharingAgreementIds(long[] sharingAgreementIds) {
		this.sharingAgreementIds = sharingAgreementIds;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public long getSubmitterId() {
		return submitterId;
	}

	public void setSubmitterId(long submitterId) {
		this.submitterId = submitterId;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public long getTicketFormId() {
		return ticketFormId;
	}

	public void setTicketFormId(long ticketFormId) {
		this.ticketFormId = ticketFormId;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Object getVia() {
		return via;
	}

	public void setVia(Object via) {
		this.via = via;
	}

	public long getViaFollowupSourceId() {
		return viaFollowupSourceId;
	}

	public void setViaFollowupSourceId(long viaFollowupSourceId) {
		this.viaFollowupSourceId = viaFollowupSourceId;
	}
}