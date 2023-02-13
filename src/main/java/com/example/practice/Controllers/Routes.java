package com.example.practice.Controllers;

import com.example.practice.Models.HotelModel;
import com.example.practice.Repositories.HotelRepository;
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
