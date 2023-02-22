package com.example.practice;

import static org.mockito.Mockito.*;

import static org.mockito.ArgumentMatchers.any;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.example.practice.Controllers.Routes;
import com.example.practice.Models.*;
import com.example.practice.Repositories.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class PracticeApplicationTests {

    @Mock
    private ProductRepository product;

    @InjectMocks
    private Routes routesController;

    @Test
    public void testGetProducts() {
        List<ProductModel> products = new ArrayList<>();
        products.add(new ProductModel(2L, "Jewellery", "Good one", "Very Good Jewellery", "Imagelink", 200L));
        when(product.findAll()).thenReturn(products);

        ResponseEntity response = routesController.get_product();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(products, response.getBody());
    }

    @Test
    public void testPostProduct() throws Exception {
        ProductModel product = new ProductModel(1L, "Shirt", "Good one", "Very Good Shirt", "Imagelink", 100L);

        ResponseEntity response = routesController.post_products(product);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Product Uploaded Successfully", response.getBody());

    }

    // @Test
    // public void testGetHotelByLocation() {
    // String location = "Location A";
    // List<ProductModel> hotels = new ArrayList<>();
    // hotels.add(new ProductModel(1L, "Hotel A", "Short description A", "Long
    // description A",
    // "https://example.com/image-a.jpg", "Location A", "Experience A", "Pool A",
    // 100L));
    // hotels.add(new ProductModel(2L, "Hotel B", "Short description B", "Long
    // description B",
    // "https://example.com/image-b.jpg", "Location B", "Experience B", "Pool B",
    // 200L));
    // when(hotelRepository.findAllByLocation(location)).thenReturn(hotels);

    // ResponseEntity response = routesController.get_hotel_by_location(location);

    // assertEquals(HttpStatus.OK, response.getStatusCode());
    // assertEquals(hotels, response.getBody());
    // }

    // @Test
    // public void testGetHotel() {
    // ProductModel hotel = new ProductModel(2L, "Hotel B", "Short description B",
    // "Long description B",
    // "https://example.com/image-b.jpg", "Location B", "Experience B", "Pool B",
    // 200L);
    // List<ProductModel> hotels = new ArrayList<>();
    // hotels.add(hotel);
    // when(hotelRepository.findAllByLocation(hotel.getLocation())).thenReturn(hotels);

    // ResponseEntity response = routesController.get_hotel(hotel);

    // assertEquals(HttpStatus.OK, response.getStatusCode());
    // assertEquals(hotels, response.getBody());
    // }
}
