package com.turkcellcamp.rentacar.repository.abstracts;

import com.turkcellcamp.rentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandRepository {

    List<Brand> getAll();

    Brand getById(int id);

    Brand add(Brand brand);

    Brand updateById(int id, Brand brand);

    void deleteById(int id);
}
