package com.javachallange.model;


import java.util.List;
import lombok.Data;


@Data
public class EarthquakeDto {
    private String place;
    private long magnitude;
    private String date;
    private String time;
    private List<Long> coordinates;

   
}
