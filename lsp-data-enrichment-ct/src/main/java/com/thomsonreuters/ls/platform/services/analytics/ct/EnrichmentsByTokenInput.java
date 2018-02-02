package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.io.Serializable;

public class EnrichmentsByTokenInput implements Serializable {
	
	private static final long serialVersionUID = 135623125105502729L;
	
	Integer hits;
    Integer offset;
    String sortingMethod = EnrichmentConsts.SORTING_SIGNIFICANCE;
    TokenList enrichment;

    public EnrichmentsByTokenInput() {
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getSortingMethod() {
        return sortingMethod;
    }

    public void setSortingMethod(String sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    public TokenList getEnrichment() {
        return enrichment;
    }

    public void setEnrichment(TokenList enrichment) {
        this.enrichment = enrichment;
    }

    @Override
    public String toString() {
        return "EnrichmentsByTokenInput{" +
                "Hits='" + hits + '\'' +
                ", Offset='" + offset + '\'' +
                ", SortingMethod='" + hits + '\'' +
                ", Enrichment='" + enrichment + '\'' +
                '}';
    }
}
