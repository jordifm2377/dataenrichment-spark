package com.thomsonreuters.ls.platform.services.analytics.ct;

import java.io.Serializable;
import java.util.List;

public class EnrichmentEntry implements Serializable {
	private static final long serialVersionUID = 3857996216363826702L;
	
	Integer id;
    String name;
    ScientificDouble minPvalue;
    ScientificDouble std;
    ScientificDouble sim;
    List<InputList> inputLists;
    List<NWObject> nwObject;

    public EnrichmentEntry() {
    }

    public EnrichmentEntry(Integer id) {
        this.id = id;
    }

    public EnrichmentEntry(Integer id, List<InputList> inputLists) {
        this.id = id;
        this.inputLists = inputLists;
    }

    public EnrichmentEntry(Integer id, String name, List<InputList> inputLists) {
        this.id = id;
        this.name = name;
        this.inputLists = inputLists;
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


    public List<InputList> getInputLists() {
        return inputLists;
    }

    public void setInputLists(List<InputList> inputLists) {
        this.inputLists = inputLists;
    }

    public List<NWObject> getNwObject() {
        return nwObject;
    }

    public void setNwObject(List<NWObject> nwObject) {
        this.nwObject = nwObject;
    }

    public ScientificDouble getMinPvalue() {
        return minPvalue;
    }

    public void setMinPvalue(ScientificDouble minPvalue) {
        this.minPvalue = minPvalue;
    }

    public ScientificDouble getStd() {
        return std;
    }

    public void setStd(ScientificDouble std) {
        this.std = std;
    }

    public ScientificDouble getSim() {
        return sim;
    }

    public void setSim(ScientificDouble sim) {
        this.sim = sim;
    }

    @Override
    public String toString() {
        return "EnrichmentEntry{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", significance='" + minPvalue + '\'' +
                ", difference='" + std + '\'' +
                ", similarity='" + sim + '\'' +
                ", Lists=" + inputLists +
                ", NWObject=" + nwObject +
                '}';
    }
}
