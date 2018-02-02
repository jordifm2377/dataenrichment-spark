package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.io.Serializable;
import java.util.List;

public class EnrichmentIds implements Serializable {
	private static final long serialVersionUID = -7837343281705548993L;
	
	private String mode;
    private List<Integer> ids;

    public EnrichmentIds() {
    }

    public EnrichmentIds(String mode, List<Integer> ids) {
        this.mode = mode;
        this.ids = ids;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
