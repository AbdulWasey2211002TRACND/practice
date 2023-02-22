package com.example.practice.Repositories;
import com.example.practice.Models.ProductModel;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductModel,Long> {

            List<ProductModel> findAllById(Long id);

}
