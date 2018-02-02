package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.util.List;
import java.util.Map;

/**
 * User: Anna Perevozchikova
 * Date: 18.09.13
 */
public class NetworkObjectInputDto {
    List<Enrichment> enrichments;
    Map<String, List<Integer>> tokenLists;

    public NetworkObjectInputDto() {
    }

    public List<Enrichment> getEnrichments() {
        return enrichments;
    }

    public void setEnrichments(List<Enrichment> enrichments) {
        this.enrichments = enrichments;
    }

    public Map<String, List<Integer>> getTokenLists() {
        return tokenLists;
    }

    public void setTokenLists(Map<String, List<Integer>> tokenLists) {
        this.tokenLists = tokenLists;
    }

    @Override
    public String toString() {
        return "EnrichmentInputDto{" +
                ", enrichments=" + enrichments +
                ", tokenLists=" + tokenLists +
                '}';
    }
}
