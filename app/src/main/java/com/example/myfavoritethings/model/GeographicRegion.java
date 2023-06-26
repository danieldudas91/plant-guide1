package com.example.myfavoritethings.model;

import java.util.HashMap;
import java.util.Map;

public enum GeographicRegion {
    GREAT_PLAIN("Great Plain"),
    TRANS_DANUBIAN_RANGE("Transdanubian Range"),
    NORTH_HUNGARIAN_MOUNTAINS("North Hungarian Mountains"),
    TRANS_DANUBIAN_HILLS("Transdanubian Hills"),
    LITTLE_ALFÖLD("Little Alföld"),
    WESTERN_CONFINE("Western Confine");
    private String label;
    private static final Map<String, GeographicRegion> lookup = new HashMap<>();

    GeographicRegion(String label) {
        this.label = label;
    }

    static {
        for (GeographicRegion d : GeographicRegion.values()) {
            lookup.put(d.getLabel(), d);
        }
    }

    public String getLabel() {
        return label;
    }
}