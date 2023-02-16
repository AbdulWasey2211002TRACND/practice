package com.example.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.practice.Controllers.Routes;
import com.example.practice.Models.*;
import com.example.practice.Repositories.HotelRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;




@SpringBootTest
class PracticeApplicationTests {

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private Routes routesController;

    @Test
    public void testGetHotels() {
        List<HotelModel> hotels = new ArrayList<>();
        hotels.add(new HotelModel(1L, "Hotel A", "Short description A", "Long description A",
                "https://example.com/image-a.jpg", "Location A", "Experience A", "Pool A", 100L));
        hotels.add(new HotelModel(2L, "Hotel B", "Short description B", "Long description B",
                "https://example.com/image-b.jpg", "Location B", "Experience B", "Pool B", 200L));
            when(hotelRepository.findAll()).thenReturn(hotels);

        ResponseEntity response = routesController.get_hotels();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(hotels, response.getBody());
    }

    @Test
    public void testGetHotelById() {
        HotelModel hotel = new HotelModel(1L, "Hotel A", "Short description A", "Long description A",
                "https://example.com/image-a.jpg", "Location A", "Experience A", "Pool A", 100L);
        when(hotelRepository.findById(1L)).thenReturn(Optional.of(hotel));
    
        ResponseEntity<Object> response = routesController.get_hotel_by_id(1L);
    
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Optional<HotelModel> data = (Optional<HotelModel>) response.getBody();
        assertEquals(hotel, data.orElse(null));
    }

    @Test
    public void testGetHotelByLocation() {
        String location = "Location A";
        List<HotelModel> hotels = new ArrayList<>();
        hotels.add(new HotelModel(1L, "Hotel A", "Short description A", "Long description A",
        "https://example.com/image-a.jpg", "Location A", "Experience A", "Pool A", 100L));
hotels.add(new HotelModel(2L, "Hotel B", "Short description B", "Long description B",
        "https://example.com/image-b.jpg", "Location B", "Experience B", "Pool B", 200L));
        when(hotelRepository.findAllByLocation(location)).thenReturn(hotels);

        ResponseEntity response = routesController.get_hotel_by_location(location);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(hotels, response.getBody());
    }

    @Test
    public void testGetHotel() {
        HotelModel hotel = new HotelModel(2L, "Hotel B", "Short description B", "Long description B",
        "https://example.com/image-b.jpg", "Location B", "Experience B", "Pool B", 200L);
        List<HotelModel> hotels = new ArrayList<>();
        hotels.add(hotel);
        when(hotelRepository.findAllByLocation(hotel.getLocation())).thenReturn(hotels);

        ResponseEntity response = routesController.get_hotel(hotel);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(hotels, response.getBody());
    }
}

