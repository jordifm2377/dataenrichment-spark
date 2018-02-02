package com.thomsonreuters.ls.platform.services.analytics.si.utils;

import com.thomsonreuters.ls.platform.services.analytics.ct.EnrichmentEntry;
import com.thomsonreuters.ls.platform.services.analytics.ct.InputList;

import java.util.Comparator;

/**
 * Created by U0171827 on 03/07/2015.
 */

public class EnrichmentPValueComparator implements Comparator<EnrichmentEntry> {
    @Override
    public int compare(EnrichmentEntry enrichmentEntry, EnrichmentEntry enrichmentEntry2) {
        InputList list1 = enrichmentEntry.getInputLists().get(0);
        InputList list2 = enrichmentEntry2.getInputLists().get(0);
        Double val1 = list1.getPvalue().getValue();
        Double val2 = list2.getPvalue().getValue();
        int result = val1.compareTo(val2);
        return result;
    }
}