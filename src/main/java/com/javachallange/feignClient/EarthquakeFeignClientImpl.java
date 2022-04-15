package com.javachallange.feignClient;

import com.javachallange.model.EarthquakeResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EarthquakeFeignClientImpl {

    @Autowired
    private EarthquakeFeignClient client;
    

    public EarthquakeResponse getEarthquakesList(String latitude,String longitude,String starttime,String endtime){
       return client.getEarthquakes("geojson",latitude,longitude,"10",starttime, endtime);
    }

    
}
