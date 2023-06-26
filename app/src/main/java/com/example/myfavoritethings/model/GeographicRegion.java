package com.example.myfavoritethings.model;

public enum GeographicRegion {
    GREAT_PLAIN("Great Plain"),
    TRANS_DANUBIAN_RANGE("Transdanubian Range"),
    NORTH_HUNGARIAN_MOUNTAINS("North Hungarian Mountains"),
    TRANS_DANUBIAN_HILLS("Transdanubian Hills"),
    LITTLE_ALFÖLD("Little Alföld"),
    WESTERN_CONFINE("Western Confine");
    private String label;

    GeographicRegion(String label) {
        this.label = label;
    }

    
}