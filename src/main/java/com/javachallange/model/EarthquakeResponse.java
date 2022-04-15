package com.javachallange.model;

import java.sql.Timestamp;
import java.util.List;

@lombok.Data
public class EarthquakeResponse  {
    private String type;
    private MetaData metadata;
    private List<Feature> features;
    private List<Long> bbox;


    @lombok.Data
    public static class MetaData {
        private Timestamp generated;
        private String url;
        private String title;
        private int status;
        private String api;
        private int count;
    }

    @lombok.Data
    public static class Feature{
        private String type;
        private Property properties;
        private Geometry geometry;
        private String id;
    }

    @lombok.Data
    public static class Property{
        private long mag;
        private String place;
        private Timestamp time;
        private Timestamp updated;
        private Object tz;
        private String url;
        private String detail;
        private long felt;
        private long cdi;
        private long mmi;
        private String alert;
        private String status;
        private long tsunami;
        private long sig;
        private String net;
        private String code;
        private String ids;
        private String sources;
        private String types;
        private long nst;
        private long dmin;
        private long rms;
        private long gap;
        private String magType;
        private String type;
        private String title;
    }

    @lombok.Data
    public static class Geometry{
        private String type;
        private List<Long> coordinates;
    }
    
}
