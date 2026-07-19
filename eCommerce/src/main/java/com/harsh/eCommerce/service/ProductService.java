package com.harsh.eCommerce.service;

import com.harsh.eCommerce.model.Product;
import com.harsh.eCommerce.repo.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getProductById(int id){
        return productRepo.findById(id).get();
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepo.save(product);

    }

    public Product updateProduct(int id,Product product,MultipartFile updatedImageFile ) throws IOException {
        System.out.println("reached product service");
        product.setImageName(updatedImageFile.getOriginalFilename());
        product.setImageData(updatedImageFile.getBytes());
        product.setImageType(updatedImageFile.getContentType());
        return productRepo.save(product);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
}
