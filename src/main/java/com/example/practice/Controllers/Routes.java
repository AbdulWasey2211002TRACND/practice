package com.example.practice.Controllers;

import com.example.practice.Models.ProductModel;
import com.example.practice.Repositories.ProductRepository;
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
@RequestMapping("products")
@RestController
public class Routes {

    @Autowired
    private ProductRepository product;

    @GetMapping("/get_products")
    public ResponseEntity get_hotels (){
        return new ResponseEntity<Object>(product.findAll(), HttpStatus.OK);    
    }
    
    @GetMapping("/get_product_by_id")
    public ResponseEntity get_hotel_by_id (@RequestParam long id){
        return new ResponseEntity<Object>(product.findAllById(id), HttpStatus.OK);    
    }
    

    @PostMapping("/post_products")
    public ResponseEntity post_hotels (@RequestBody ProductModel requesthotel){

        product.save(requesthotel);
        return new ResponseEntity<Object>("Product Uploaded Successfully" ,HttpStatus.OK);    
    }

   
}
