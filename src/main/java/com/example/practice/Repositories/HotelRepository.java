package com.example.practice.Repositories;
import com.example.practice.Models.HotelModel;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
@Transactional
public interface HotelRepository extends JpaRepository<HotelModel,Long> {

    

    List<HotelModel> findAllByLocation (String location);

}
