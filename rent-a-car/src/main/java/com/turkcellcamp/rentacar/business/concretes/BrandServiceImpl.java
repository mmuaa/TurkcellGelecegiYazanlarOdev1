package com.turkcellcamp.rentacar.business.concretes;

import com.turkcellcamp.rentacar.business.abstracts.BrandService;
import com.turkcellcamp.rentacar.entities.concretes.Brand;
import com.turkcellcamp.rentacar.repository.abstracts.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAll() {
        if (brandRepository.getAll().size() == 0) {
            throw new RuntimeException("Brand not found");
        }
        return brandRepository.getAll();
    }

    @Override
    public Brand getById(int id) {
        return brandRepository.getById(id);
    }

    @Override
    public Brand add(Brand brand) {
        checkBrandNameValid(brand.getName());
        return brandRepository.add(brand);
    }

    @Override
    public Brand updateById(int id, Brand brand) {
        checkBrandNameValid(brand.getName());
        return brandRepository.updateById(id, brand);
    }

    @Override
    public void deleteById(int id) {
        brandRepository.deleteById(id);
    }

    private void checkBrandNameValid(String brandName) {
        if (brandName.length() < 2) {
            throw new IllegalArgumentException("Brand name can not be less than 2");
        }
    }
}
