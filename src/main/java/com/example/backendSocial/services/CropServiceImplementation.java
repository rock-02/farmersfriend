package com.example.backendSocial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendSocial.Entity.Crops;
import com.example.backendSocial.repositories.CropRepository;

@Service
public class CropServiceImplementation implements CropService {

    @Autowired
    private CropRepository cropRepository;

    @Override
    public Crops findCropByID(Long id) throws Exception {
        return cropRepository
                .findById(id)
                .orElseThrow(
                        () -> new Exception("Crop not found"));
    }

    @Override
    public Crops CrateCrop(Crops crop) throws Exception {
        return cropRepository.save(crop);

    }

    @Override
    public List<Crops> findByCropNameCropSoilCropSeason(String query) throws Exception {
        return cropRepository.findByCropNameCropSoilCropSeason(query);
    }

}
