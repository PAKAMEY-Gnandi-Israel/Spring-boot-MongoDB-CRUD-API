package com.Otaku.Blog.controller;

import com.Otaku.Blog.model.product;
import com.Otaku.Blog.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity addProduct(@RequestBody product product){
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity updateProduct(@RequestBody product product){
        productService.updateProduct(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<product>> getAllProduct(){
        return (ResponseEntity<List<product>>) ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/{name}")
    public ResponseEntity<product> getProductByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
