package com.zendesk.java;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {

    private String nextUrl;
    private String prevUrl;

    public Links() {}

    @JsonCreator
    public Links(
            @JsonProperty("next") String nextUrl,
            @JsonProperty("prev") String prevUrl
    ) {
        this.setNextUrl(nextUrl);
        this.setPrevUrl(prevUrl);
    }

	public String getNextUrl() {
		return nextUrl;
	}

	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}

	public String getPrevUrl() {
		return prevUrl;
	}

	public void setPrevUrl(String prevUrl) {
		this.prevUrl = prevUrl;
	}
}