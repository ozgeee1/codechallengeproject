# codechallengeproject

#Özge Özkan

Use Get Request("/getEarthquakes")  
parameters Country,countOfDays
Country=RequestBody (latitude,longitude)
ex: {
    "longitude":"40.240002",
    "latitude":"37.910000"
}


countOfDays = RequestParam(countOfDays)
ex:http://localhost:8080/getEarthquakes?countOfDays=5

