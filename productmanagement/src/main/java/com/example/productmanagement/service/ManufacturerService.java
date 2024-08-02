package com.example.productmanagement.service;

import com.example.productmanagement.entity.Manufacturer;
import com.example.productmanagement.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer addManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public Manufacturer updateManufacturer(Long id, Manufacturer manufacturer) {
        Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(id);
        if (optionalManufacturer.isPresent()) {
            Manufacturer existingManufacturer = optionalManufacturer.get();
            existingManufacturer.setName(manufacturer.getName());
            existingManufacturer.setOrigin(manufacturer.getOrigin());
            existingManufacturer.setDescription(manufacturer.getDescription());
            return manufacturerRepository.save(existingManufacturer);
        }
        return null;
    }

    public boolean deleteManufacturer(Long id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(id);
        if (optionalManufacturer.isPresent() && optionalManufacturer.get().getProducts().isEmpty()) {
            manufacturerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
