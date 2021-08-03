package com.zendesk.java;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {

    private Boolean hasMore;
    private String afterCursor;
    private String beforeCursor;

    public Meta() {}

    @JsonCreator
    public Meta(
            @JsonProperty("has_more") boolean hasMore,
            @JsonProperty("after_cursor") String afterCursor,
            @JsonProperty("before_cursor") String beforeCursor
    ) {
        this.setHasMore(hasMore);
        this.setAfterCursor(afterCursor);
        this.setBeforeCursor(beforeCursor);
    }

	public Boolean getHasMore() {
		return hasMore;
	}

	public void setHasMore(Boolean hasMore) {
		this.hasMore = hasMore;
	}

	public String getAfterCursor() {
		return afterCursor;
	}

	public void setAfterCursor(String afterCursor) {
		this.afterCursor = afterCursor;
	}

	public String getBeforeCursor() {
		return beforeCursor;
	}

	public void setBeforeCursor(String beforeCursor) {
		this.beforeCursor = beforeCursor;
	}
}