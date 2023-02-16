package com.example.practice.Controllers;

import com.example.practice.Models.HotelModel;
import com.example.practice.Repositories.HotelRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;






@CrossOrigin
@RequestMapping("hotels")
@RestController
public class Routes {

    @Autowired
    private HotelRepository hotel;

    @GetMapping("/get_hotels")
    public ResponseEntity get_hotels (){
        return new ResponseEntity<Object>(hotel.findAll(), HttpStatus.OK);    
    }
    
    @GetMapping("/get_hotel_by_id")
    public ResponseEntity get_hotel_by_id (@RequestParam long id){
        return new ResponseEntity<Object>(hotel.findById(id), HttpStatus.OK);    
    }

    @GetMapping("/get_hotel_by_location")
    public ResponseEntity get_hotel_by_location (@RequestParam String location)
    {

        
        List<HotelModel> data = hotel.findAllByLocation(location);
        return new ResponseEntity<Object>(data,HttpStatus.OK) ;  
    };

    @PostMapping("/get_hotel")
    public ResponseEntity get_hotel (@RequestBody HotelModel hotelmodel)
    {

        List<HotelModel> data = hotel.findAllByLocation(hotelmodel.getLocation());
        List<HotelModel> query =  data.stream().filter(i -> i.getPool().equals(hotelmodel.getPool())).filter(i -> i.getExperience().equals(hotelmodel.getExperience())).collect(Collectors.toList());
        return new ResponseEntity<Object>(query,HttpStatus.OK) ;  
    };
    
    
    

    @PostMapping("/post_hotels")
    public ResponseEntity post_hotels (@RequestBody HotelModel requesthotel){

        hotel.save(requesthotel);
        return new ResponseEntity<Object>("Hotel Uploaded Successfully" ,HttpStatus.OK);    
    }

    @DeleteMapping("/delete_hotel")
    public ResponseEntity post_hotels (@RequestParam long id){

        hotel.deleteById(id);;
        return new ResponseEntity<Object>("Hotel Deleted Successfully" ,HttpStatus.OK);    
    }
}
