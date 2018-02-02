package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.io.Serializable;

public class NWObject implements Serializable {
	private static final long serialVersionUID = 1976435074382775935L;
	
	Integer id;
    String name;

    public NWObject() {
    }

    public NWObject(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NWObject{" +
                "id=" + id +
                ", Name='" + name + '\''+
                '}';
    }
}
