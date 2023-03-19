package com.turkcellcamp.rentacar.api.controllers;

import com.turkcellcamp.rentacar.business.abstracts.BrandService;
import com.turkcellcamp.rentacar.entities.concretes.Brand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PostMapping
    public Brand add(@RequestBody Brand brand) {
        return brandService.add(brand);
    }

    @PutMapping("/{id}")
    public Brand updateById(@PathVariable int id, @RequestBody Brand brand) {
        return brandService.updateById(id, brand);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        brandService.deleteById(id);
    }
}
