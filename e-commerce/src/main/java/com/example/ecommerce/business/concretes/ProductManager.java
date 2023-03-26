package com.example.ecommerce.business.concretes;

import com.example.ecommerce.business.abstractcs.ProductService;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(int id) {
        checkIfProductExist(id);
        return repository.findById(id);
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return repository.save(product);
    }

    @Override
    public Product update(int id, Product product) {
        checkIfProductExist(id);
        validateProduct(product);
        product.setId(id);
        return repository.save(product);
    }

    @Override
    public void delete(int id) {
        checkIfProductExist(id);
        repository.deleteById(id);
    }


    private void validateProduct(Product product){
        checkIfUnitPriceValid(product);
        checkIfDescriptionLengthValid(product);
        checkIfQuantityValid(product);
    }

    private void checkIfProductExist(int id){
        if(!repository.existsById(id)) throw new IllegalArgumentException("Böyle bir ürün mevcut değil");
    }
    private void checkIfUnitPriceValid(Product product){
        if(product.getUnitPrice() <= 0) throw new IllegalArgumentException("Price cannot be less than or equal to zero");
    }
    private void checkIfQuantityValid(Product product){
        if(product.getQuantity() < 0 )  throw new IllegalArgumentException("Quantitu cannot be less than zero");
    }
    private void checkIfDescriptionLengthValid(Product product) {
        if(product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new IllegalArgumentException("Description length must be between 10 and 50 characters");
    }
}
