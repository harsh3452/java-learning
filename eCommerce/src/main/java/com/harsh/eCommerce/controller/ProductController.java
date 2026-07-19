package com.harsh.eCommerce.controller;

import com.harsh.eCommerce.model.Product;
import com.harsh.eCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String root(){
        return "The root path is called";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        System.out.println("Reached addProduct()");
        try {
            Product product1 =  productService.addProduct(product,imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e) {
          return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable int id){
        Product product = productService.getProductById(id);
        byte[] imageFile = product.getImageData();
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart Product product, @RequestPart MultipartFile imageFile){
        System.out.println("reached product controller");
        Product product1;
        try {
            product1 = productService.updateProduct(id,product,imageFile);
        } catch (IOException e) {
            return new ResponseEntity<>("Update Failed", HttpStatus.BAD_REQUEST);
        }
        if(product1 != null){
            return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("updated failed", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = productService.getProductById(id);
        if(product != null){
            productService.deleteProduct(id);
            return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product Not Found",HttpStatus.NOT_FOUND);
        }
    }
}
