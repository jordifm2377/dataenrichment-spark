package com.thomsonreuters.ls.platform.services.analytics.ct;


public class EnrichmentConsts {
	
	public static final String SORT_BY_PVALUE = "pvalue";
    public static final String SORT_BY_FDR = "FDR";

    public static final String HUMAN = "human";
    public static final String RAT = "rat";
    public static final String MOUSE = "mouse";

    public static final String INTERSECT = "intersection";
    public static final String UNION = "union";

    public static final String HIERARCHY = "hierarchy";
    public static final String LIST_OF_IDS = "listOfIds";

    public static final String SORTING_SIGNIFICANCE="significance";
    public static final String SORTING_DIFFERENCE="difference";
    public static final String SORTING_SIMILARITY="similarity";

    public static class Types {
        public static final String MAPS = "Maps";
        public static final String MAP_FOLDERS = "MapFolders";
        public static final String MAP_CATEGORIES = "MapCategories";
        public static final String PROCESS_NETWORKS = "ProcessNetworks";
        public static final String DRUG_TARGET_NETWORKS = "DrugTargetNetworks";
        public static final String DISEASES_NETWORKS = "DiseaseBiomarkerNetworks";
        public static final String TOXICITY_NETWORKS = "ToxicityNetworks";
        public static final String METABOLIC_NETWORKS = "MetabolicNetworks";
        public static final String METABOLIC_NETWORKS_ENDOGENOUSE = "MetabolicNetworksEndogenous";
        public static final String DISEASES = "Diseases";
        public static final String TOXICITY = "Toxicity";
        public static final String PROCESSES = "Processes";
        public static final String MOLFUNCTIONS = "MolecularFunctions";
        public static final String LOCALIZATIONS = "Localizations";
    }
}
