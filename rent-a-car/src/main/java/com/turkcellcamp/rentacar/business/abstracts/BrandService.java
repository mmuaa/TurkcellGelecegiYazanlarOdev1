package com.turkcellcamp.rentacar.business.abstracts;

import com.turkcellcamp.rentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getAll();

    Brand getById(int id);

    Brand add(Brand brand);

    Brand updateById(int id, Brand brand);

    void deleteById(int id);
}
