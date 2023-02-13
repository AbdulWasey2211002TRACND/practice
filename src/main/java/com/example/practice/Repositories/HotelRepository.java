package com.example.practice.Repositories;
import com.example.practice.Models.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelModel,Long> {

    

    
    
}
