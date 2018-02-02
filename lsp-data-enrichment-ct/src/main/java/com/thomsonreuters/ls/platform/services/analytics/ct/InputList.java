package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.io.Serializable;
import java.util.List;

public class InputList implements Serializable{
	private static final long serialVersionUID = 7602331644143406236L;
	
	String token;
    ScientificDouble pvalue;
    Integer intersection;
    Integer total;
    ScientificDouble FDR;
    List<NWObject> nwObject;

    public InputList() {
    }

    public InputList(String token, List<NWObject> nwObject) {
        this.token = token;
        this.nwObject = nwObject;
    }

    public InputList(String token, Double pvalue, Integer intersection, Integer total) {
        this.token = token;
        this.pvalue = ScientificDouble.wrap(pvalue);
        this.intersection = intersection;
        this.total = total;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public ScientificDouble getPvalue() {
        return pvalue;
    }

    public void setPvalue(ScientificDouble pvalue) {
        this.pvalue = pvalue;
    }

    public Integer getIntersection() {
        return intersection;
    }

    public void setIntersection(Integer intersection) {
        this.intersection = intersection;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public ScientificDouble getFDR() {
        return FDR;
    }

    public void setFDR(ScientificDouble FDR) {
        this.FDR = FDR;
    }

    public List<NWObject> getNwObject() {
        return nwObject;
    }

    public void setNwObject(List<NWObject> nwObject) {
        this.nwObject = nwObject;
    }

    @Override
    public String toString() {
        return "InputList{" +
                "token='" + token  + '\'' +
                ", pvalue='" + pvalue  + '\'' +
                ", intersection='" + intersection  + '\'' +
                ", total='" + total  + '\'' +
                ", fdr='" + FDR  + '\'' +
                ", nwObject=" + nwObject  +
                '}';
    }
}
