package com.javachallange.controller;


import java.time.LocalDateTime;
import java.util.List;
import com.javachallange.error.ApiMessage;
import com.javachallange.feignClient.EarthquakeFeignClientImpl;
import com.javachallange.model.Country;
import com.javachallange.model.EarthquakeDto;
import com.javachallange.util.ConverterUtil;
import com.javachallange.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EarthquakeController {

    @Autowired
    EarthquakeFeignClientImpl clientImpl;

    
    @GetMapping("/getEarthquakes")
    public ResponseEntity<?> getList(@RequestBody Country country,@RequestParam String countOfDays){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime then = now.minusDays(Integer.parseInt(countOfDays));
        String starttime = DateUtil.datetimeToStringDate(then);
        String endtime =DateUtil.datetimeToStringDate(now);
        List<EarthquakeDto> dtoList = ConverterUtil.responseToDto(clientImpl.getEarthquakesList(country.getLatitude(),country.getLongitude(),starttime, endtime));
        if(dtoList.isEmpty()){
            ApiMessage message = new ApiMessage(String.format("No Earthquakes were recorded past %s days", countOfDays));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        
        return ResponseEntity.ok().body(dtoList);
       

    }

    
}
