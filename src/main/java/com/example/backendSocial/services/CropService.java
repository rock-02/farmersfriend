package com.example.backendSocial.services;

import java.util.List;

import com.example.backendSocial.Entity.Crops;

public interface CropService {

    public Crops findCropByID(Long id) throws Exception;

    public Crops CrateCrop(Crops crop) throws Exception;

    List<Crops> findByCropNameCropSoilCropSeason(String query) throws Exception;

}
