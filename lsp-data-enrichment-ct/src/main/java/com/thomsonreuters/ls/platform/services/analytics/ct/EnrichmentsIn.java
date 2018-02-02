package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.io.Serializable;

public class EnrichmentsIn implements Serializable {
	private static final long serialVersionUID = 2397699203237221847L;
	
	private String type;
    private EnrichmentIds include;
    private EnrichmentIds exclude;

    public EnrichmentsIn() {
    }

    public EnrichmentsIn(String type, EnrichmentIds include, EnrichmentIds exclude) {
        this.type = type;
        this.include = include;
        this.exclude = exclude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EnrichmentIds getInclude() {
        return include;
    }

    public void setInclude(EnrichmentIds include) {
        this.include = include;
    }

    public EnrichmentIds getExclude() {
        return exclude;
    }

    public void setExclude(EnrichmentIds exclude) {
        this.exclude = exclude;
    }
}
