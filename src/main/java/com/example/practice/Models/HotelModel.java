package com.example.practice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;





@Table(name = "Hotels")
@Entity
@Data
@Getter
@Setter
 
public class HotelModel {

    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    // columns
    private Long id;

    String name;
    @Lob

    String short_description;
    @Lob

    String long_description;
    String image_link;
    String location;
    String experience;
    String pool;
    Long price;
    
    
   

    public HotelModel(Long id, String name, String short_description, String long_description, String image_link,
            String location, String experience, String pool,Long price) {
        this.id = id;
        this.name = name;
        this.short_description = short_description;
        this.long_description = long_description;
        this.image_link = image_link;
        this.location = location;
        this.experience = experience;
        this.pool = pool;
        this.price = price;

    }

    public HotelModel() {
    }

   

    
}
