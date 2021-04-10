package com.Otaku.Blog.service;

import com.Otaku.Blog.Repository.ProductRepository;
import com.Otaku.Blog.model.product;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
@Transactional
@RestController

public class ProductService {
    private final ProductRepository productRepository ;



    public ProductService( ProductRepository productRepository ) {
        this.productRepository = productRepository;
    }


    public void addProduct(product product ){
        productRepository.insert(product);
    }
    public void updateProduct(product product){
        product savedProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("ne peut pas trouver ce produit par son id %S",product.getId())));
        savedProduct.setProductName(product.getProductName());
        savedProduct.setProductcategory(product.getProductcategory());
        savedProduct.setProductAmount(product.getProductAmount());

        productRepository.save(product);

    }
    public List<product> getAllProduct(){
        return  productRepository.findAll();
    }
    public product getProductByName( String name){
        return productRepository.findByName(name).orElseThrow(() -> new RuntimeException(
                String.format("le produit est introuvable par son nom %S",name)));

    }
    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }
}
