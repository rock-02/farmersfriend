package com.example.backendSocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendSocial.Entity.Crops;
import com.example.backendSocial.services.CropService;

@RestController
public class CropSuggestController {

    @Autowired
    private CropService cropService;

    @PostMapping("/crop")
    public Crops createCrop(@RequestBody Crops crop) throws Exception {
        return cropService.CrateCrop(crop);
    }

    @GetMapping("/crop")
    public List<Crops> findCrop(@RequestParam String query)
            throws Exception {

       
        System.out.println("Query --> " + query);
        

        List<Crops> crops = cropService.findByCropNameCropSoilCropSeason(query);
        return crops;
    }

}
