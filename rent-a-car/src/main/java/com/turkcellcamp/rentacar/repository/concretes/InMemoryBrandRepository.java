package com.turkcellcamp.rentacar.repository.concretes;

import com.turkcellcamp.rentacar.entities.concretes.Brand;
import com.turkcellcamp.rentacar.repository.abstracts.BrandRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBrandRepository implements BrandRepository {

    List<Brand> brands;

    public InMemoryBrandRepository() {
        this.brands = new ArrayList<>();
        brands.add(new Brand(1, "Mercedes"));
        brands.add(new Brand(2, "BMW"));
        brands.add(new Brand(3, "Audi"));
    }

    @Override
    public List<Brand> getAll() {
        return brands;
    }

    @Override
    public Brand getById(int id) {
        return brands.get(id-1);
    }

    @Override
    public Brand add(Brand brand) {
        brands.add(brand);
        return brand;
    }

    @Override
    public Brand updateById(int id, Brand brand) {
        return brands.set(id-1, brand);
    }

    @Override
    public void deleteById(int id) {
        brands.remove(id-1);
    }
}
