package com.javachallange.util;

import java.util.ArrayList;
import java.util.List;

import com.javachallange.model.EarthquakeDto;
import com.javachallange.model.EarthquakeResponse;
import com.javachallange.model.EarthquakeResponse.Feature;

public class ConverterUtil {

    public static  List<EarthquakeDto> responseToDto(EarthquakeResponse res){
        List<EarthquakeDto> dtoList = new ArrayList<EarthquakeDto>();
        for(Feature f: res.getFeatures()){
            EarthquakeDto dto = new EarthquakeDto();
            dto.setPlace(f.getProperties().getPlace());
            dto.setMagnitude(f.getProperties().getMag());
            dto.setDate(DateUtil.datetimeToStringDate(f.getProperties().getTime().toLocalDateTime()));
            dto.setTime(DateUtil.datetimeToStringTime(f.getProperties().getTime().toLocalDateTime()));
            dto.setCoordinates(f.getGeometry().getCoordinates());
            dtoList.add(dto);
            
        }
        return dtoList;
        
    }
    
}
