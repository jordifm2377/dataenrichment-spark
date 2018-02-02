package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.io.Serializable;

public class TokenList implements Serializable {

	private static final long serialVersionUID = 7533203742627108518L;
	
	private String token;

    public TokenList() {}
    
    public TokenList(String token) {
    	this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
