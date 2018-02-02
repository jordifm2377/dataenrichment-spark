package com.thomsonreuters.ls.platform.services.analytics.ct;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by U0139062 on 17.03.14.
 */
@XmlType
public class ScientificDouble extends Number implements Serializable {
    Double value;

    public ScientificDouble() {
    }

    public ScientificDouble(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public static ScientificDouble wrap(Double value) {
        return value == null ? null : new ScientificDouble(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public int intValue() {
        return value.intValue();
    }

    @Override
    public long longValue() {
        return value.longValue();
    }

    @Override
    public float floatValue() {
        return value.floatValue();
    }

    @Override
    public double doubleValue() {
        return value;
    }


}