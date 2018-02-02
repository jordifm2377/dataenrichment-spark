package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.io.Serializable;

public class BackgroundList implements Serializable {
	private static final long serialVersionUID = 1951011157604296193L;
	
	private Integer id;
    private String token;

    public BackgroundList() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
