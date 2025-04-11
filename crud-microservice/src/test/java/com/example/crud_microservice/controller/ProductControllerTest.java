package com.example.crud_microservice.controller;

import com.example.crud_microservice.model.Product;
import com.example.crud_microservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void testGetAllProducts() throws Exception {
        Product product = new Product();
        product.setId(1L);
        product.setName("Monitor");
        product.setPrice(300.0);

        when(productService.findAll()).thenReturn(List.of(product));

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Monitor"));
    }

    @Test
    void testGetProductById() throws Exception {
        Product product = new Product();
        product.setId(2L);
        product.setName("Teclado");
        product.setPrice(50.0);

        when(productService.findById(2L)).thenReturn(product);

        mockMvc.perform(get("/products/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Teclado"));
    }

    @Test
    void testCreateProduct() throws Exception {
        Product product = new Product();
        product.setName("Mouse");
        product.setPrice(25.0);

        Product saved = new Product();
        saved.setId(3L);
        saved.setName("Mouse");
        saved.setPrice(25.0);

        when(productService.save(any(Product.class))).thenReturn(saved);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3));
    }

    @Test
    void testUpdateProduct() throws Exception {
        Product product = new Product();
        product.setId(4L);
        product.setName("Headset");
        product.setPrice(75.0);

        when(productService.save(any(Product.class))).thenReturn(product);

        mockMvc.perform(put("/products/4")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Headset"));
    }

    @Test
    void testDeleteProduct() throws Exception {
        doNothing().when(productService).delete(5L);

        mockMvc.perform(delete("/products/5"))
                .andExpect(status().isOk());
    }
}
