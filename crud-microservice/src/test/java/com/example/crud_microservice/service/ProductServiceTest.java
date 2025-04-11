package com.example.crud_microservice.service;

import com.example.crud_microservice.model.Product;
import com.example.crud_microservice.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Product p1 = new Product(1L, "Mouse", 30.0);
        Product p2 = new Product(2L, "Teclado", 50.0);

        when(productRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Product> result = productService.findAll();

        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Product product = new Product(1L, "Monitor", 200.0);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product result = productService.findById(1L);

        assertNotNull(result);
        assertEquals("Monitor", result.getName());
    }

    @Test
    void testSave() {
        Product product = new Product(null, "Audífonos", 80.0);
        Product saved = new Product(1L, "Audífonos", 80.0);

        when(productRepository.save(product)).thenReturn(saved);

        Product result = productService.save(product);

        assertNotNull(result.getId());
        assertEquals("Audífonos", result.getName());
    }

    @Test
    void testDelete() {
        doNothing().when(productRepository).deleteById(1L);

        productService.delete(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }
}
