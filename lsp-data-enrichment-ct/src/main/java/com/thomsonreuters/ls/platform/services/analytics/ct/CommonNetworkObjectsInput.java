package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.util.List;


public class CommonNetworkObjectsInput {
   
    List<Enrichment> enrichments;

    
    List<TokenList> tokenLists;

    public CommonNetworkObjectsInput() {
    }
   
    public List<Enrichment> getEnrichments() {
        return enrichments;
    }

    public void setEnrichments(List<Enrichment> enrichments) {
        this.enrichments = enrichments;
    }

    public List<TokenList> getTokenLists() {
        return tokenLists;
    }

    public void setTokenLists(List<TokenList> tokenLists) {
        this.tokenLists = tokenLists;
    }
}
