package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.util.List;


public class Enrichment {
   
    String type;
    
    List<Integer> entries;

    public Enrichment() {
    }

    public Enrichment(String type, List<Integer> entries) {
        this.type = type;
        this.entries = entries;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Integer> getEntries() {
        return entries;
    }

    public void setEntries(List<Integer> entries) {
        this.entries = entries;
    }
}
