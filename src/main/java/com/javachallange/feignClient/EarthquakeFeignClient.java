package com.javachallange.feignClient;

import com.javachallange.model.EarthquakeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient(name="earthquake",url="https://earthquake.usgs.gov/fdsnws/event/1",configuration = FeignConfig.class)
public interface EarthquakeFeignClient {

    @GetMapping(value="/query")
    public EarthquakeResponse getEarthquakes(@RequestParam String format,@RequestParam(required = true) String latitude,@RequestParam(required = true) String longitude,@RequestParam(required = true) String maxradius,@RequestParam(required = true) String starttime,@RequestParam(required = true) String endtime) ;
    
}
