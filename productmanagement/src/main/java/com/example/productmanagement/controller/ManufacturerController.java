package com.example.productmanagement.controller;

import com.example.productmanagement.entity.Manufacturer;
import com.example.productmanagement.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.getAllManufacturers();
    }

    @PostMapping
    public Manufacturer addManufacturer(@RequestBody Manufacturer manufacturer) {
        return manufacturerService.addManufacturer(manufacturer);
    }

    @PutMapping("/{id}")
    public Manufacturer updateManufacturer(@PathVariable Long id, @RequestBody Manufacturer manufacturer) {
        return manufacturerService.updateManufacturer(id, manufacturer);
    }

    @DeleteMapping("/{id}")
    public boolean deleteManufacturer(@PathVariable Long id) {
        return manufacturerService.deleteManufacturer(id);
    }
}
