package com.example.practice;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.practice.Controllers.Routes;
import com.example.practice.Models.*;
import com.example.practice.Repositories.ProductRepository;

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

    @Test
    public void testGetProductById() {
        ProductModel myproduct = new ProductModel(1L, "Shirt", "Good one", "Very Good Shirt", "Imagelink", 100L);
        when(product.findById(1L)).thenReturn(Optional.of(myproduct));

        ResponseEntity<Object> response = routesController.get_product_by_id(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testConstructorAndGetters() {
        Long id = 1L;
        String name = "Shirt";
        String short_description = "Good one";
        String long_description = "Very Good Shirt";
        String image_link = "Imagelink";
        Long price = 100L;

        ProductModel product = new ProductModel(id, name, short_description, long_description, image_link, price);

        assertEquals(id, product.getId());
        assertEquals(name, product.getName());
        assertEquals(short_description, product.getShort_description());
        assertEquals(long_description, product.getLong_description());
        assertEquals(image_link, product.getImage_link());
        assertEquals(price, product.getPrice());
    }

    @Test
    void testSetters() {
        ProductModel product = new ProductModel();

        Long id = 1L;
        String name = "Shirt";
        String short_description = "Good one";
        String long_description = "Very Good Shirt";
        String image_link = "Imagelink";
        Long price = 100L;

        product.setId(id);
        product.setName(name);
        product.setShort_description(short_description);
        product.setLong_description(long_description);
        product.setImage_link(image_link);
        product.setPrice(price);

        assertEquals(id, product.getId());
        assertEquals(name, product.getName());
        assertEquals(short_description, product.getShort_description());
        assertEquals(long_description, product.getLong_description());
        assertEquals(image_link, product.getImage_link());
        assertEquals(price, product.getPrice());
    }

    @Test
    void testEquals() {
        ProductModel product1 = new ProductModel(1L, "Shirt", "Good one", "Very Good Shirt", "Imagelink", 100L);
        ProductModel product2 = new ProductModel(1L, "Shirt", "Good one", "Very Good Shirt", "Imagelink", 100L);
        ProductModel product3 = new ProductModel(2L, "Pants", "Good one", "Very Good Pants", "Imagelink", 200L);

        assertEquals(product1, product2);
        assertNotEquals(product1, product3);
    }

}
