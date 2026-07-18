package com.harsh.springwebapp.service;

import com.harsh.springwebapp.model.Product;
import com.harsh.springwebapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

//    List<Product> list = new ArrayList<>(Arrays.asList(
//            new Product(1, "iPhone 15", 79999),
//            new Product(2, "Samsung Galaxy S24", 74999),
//            new Product(3, "Google Pixel 8", 69999),
//            new Product(4, "OnePlus 12", 64999),
//            new Product(5, "MacBook Air M2", 99999),
//            new Product(6, "Dell XPS 13", 119999),
//            new Product(7, "Sony WH-1000XM5", 29999),
//            new Product(8, "Apple Watch Series 9", 41999),
//            new Product(9, "iPad Air", 59999),
//            new Product(10, "Logitech MX Master 3S", 8999)
//        )
//    );

    public  List<Product> getProducts(){
//        return list;
        return productRepo.findAll();
    }

    public Product getProductById(int id){
//         return list.stream()
//                .filter(p-> p.getId() == id)
//                .findFirst().get();
        return productRepo.getReferenceById(id);

    }

    public void addProduct( Product product) {
//            list.add(product);
            productRepo.save(product);
        }

    public void updateProduct(Product prod) {
//        int index = getIndex(prod.getId());
//            list.set(index,prod);
        productRepo.save(prod);
        }
    public void deleteProductById(int id){
//        int index = getIndex(id);
//        list.remove(index);
    productRepo.deleteById(id);
    }
//    public int getIndex(int id) {
//        int index = 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId() == id) {
//                index = i;
//            }
//        }
//        return index;
//    }
}
