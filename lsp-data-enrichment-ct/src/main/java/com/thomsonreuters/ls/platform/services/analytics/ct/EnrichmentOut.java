package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.io.Serializable;
import java.util.List;

public class EnrichmentOut implements Serializable{
	private static final long serialVersionUID = -7936289901485117341L;
	
	String type;
    String token;
    Integer limit;
    Integer count;
    List<EnrichmentEntry> entries;

    public EnrichmentOut() {
    }

    public EnrichmentOut(String type, List<EnrichmentEntry> entries) {
        this.type = type;
        this.entries = entries;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<EnrichmentEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<EnrichmentEntry> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "EnrichmentOut{" +
                "type='\"" + type  + '\'' +
                ", Token='" + token + '\'' +
                ", limit='" + limit + '\'' +
                ", count='" + count + '\'' +
                ", Entries=" + entries +
                '}';
    }
}