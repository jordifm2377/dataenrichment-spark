package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.io.Serializable;
import java.util.List;

public class Enrichments implements Serializable {
	private static final long serialVersionUID = -5183267348924440445L;
	
	List<EnrichmentOut> enrichmentOuts;
    String token;
    Integer hits;
    Integer offset;
    String setMode;
    String sortingMethod;

    public Enrichments() {
    }

    public Enrichments(List<EnrichmentOut> enrichmentOuts) {
        this.enrichmentOuts = enrichmentOuts;
    }

    public List<EnrichmentOut> getEnrichmentOuts() {
        return enrichmentOuts;
    }

    public void setEnrichmentOuts(List<EnrichmentOut> enrichmentOuts) {
        this.enrichmentOuts = enrichmentOuts;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getSetMode() {
        return setMode;
    }

    public void setSetMode(String setMode) {
        this.setMode = setMode;
    }

    public String getSortingMethod() {
        return sortingMethod;
    }

    public void setSortingMethod(String sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    @Override
    public String toString() {
        return "Enrichments{" +
                "enrichmentOuts=" + enrichmentOuts +
                ", Token='" + token + '\'' +
                ", Hits='" + hits + '\'' +
                ", Offset='" + offset + '\'' +
                ", SetMode='" + setMode + '\'' +
                ", SortingMethod='" + hits + '\'' +
                '}';
    }
}