package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.io.Serializable;

public class EnrichmentsByTokenOutput implements Serializable{
	private static final long serialVersionUID = 354929308344002159L;
	
	Enrichments enrichments;

    public EnrichmentsByTokenOutput() {
    }

    public Enrichments getEnrichments() {
        return enrichments;
    }

    public void setEnrichments(Enrichments enrichments) {
        this.enrichments = enrichments;
    }
}
