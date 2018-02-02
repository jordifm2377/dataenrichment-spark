package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.io.Serializable;
import java.util.List;

public class EnrichmentInput implements Serializable {

	private static final long serialVersionUID = -3336001517436676661L;
	
	private List<EnrichmentsIn> enrichments;
    private List<TokenList> lists;
    private List<BackgroundList> backgroundList;
    private String setMode;

    public EnrichmentInput() {}

    public List<EnrichmentsIn> getEnrichments() {
        return enrichments;
    }

    public void setEnrichments(List<EnrichmentsIn> enrichmentsIn) {
        this.enrichments = enrichmentsIn;
    }

    public List<TokenList> getLists() {
        return lists;
    }

    public void setLists(List<TokenList> lists) {
        this.lists = lists;
    }

    public List<BackgroundList> getBackgroundList() {
        return backgroundList;
    }

    public void setBackgroundList(List<BackgroundList> backgroundList) {
        this.backgroundList = backgroundList;
    }

    public String getSetMode() {
        return setMode == null ? EnrichmentConsts.INTERSECT : setMode;
    }

    public void setSetMode(String setMode) {
        this.setMode = setMode;
    }

    @Override
    public String toString() {
        return "EnrichmentInput{" +
                ", setMode='" + setMode + '\'' +
                ", enrichments=" + enrichments +
                ", lists=" + lists +
                ", backgroundList=" + backgroundList +
                '}';
    }
}
