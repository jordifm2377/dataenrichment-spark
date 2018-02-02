package com.thomsonreuters.ls.platform.services.analytics.ct;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;


public class CommonNetworkObjectsOutput implements Serializable {
    List<EnrichmentOut> enrichments;

    public CommonNetworkObjectsOutput() {
    }

    public CommonNetworkObjectsOutput(List<EnrichmentOut> enrichments) {
        this.enrichments = enrichments;
    }
    
    public List<EnrichmentOut> getEnrichments() {
        return enrichments;
    }

    public void setEnrichments(List<EnrichmentOut> enrichments) {
        this.enrichments = enrichments;
    }
}
