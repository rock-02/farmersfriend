package com.example.backendSocial.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendSocial.Entity.CropWaste;
import com.example.backendSocial.Entity.User;
import com.example.backendSocial.repositories.CropWasteRepository;
import com.example.backendSocial.response.CropWasteResponse;

@Service
public class CropWasteServiceImplementation implements CropWasterService {

    @Autowired
    private CropWasteRepository cropWasteRepository;

    @Override
    public CropWaste CreateCropWaste(CropWaste cropWaste, User user) {

        CropWaste newCropWaste = new CropWaste();
        newCropWaste.setCropName(cropWaste.getCropName());
        newCropWaste.setQuantity(cropWaste.getQuantity());
        newCropWaste.setUser(user);
        newCropWaste.setCreatedAt(new Date(System.currentTimeMillis()));
        CropWaste savedCropWaste = cropWasteRepository.save(newCropWaste);
        return savedCropWaste;
    }

    @Override
    public CropWaste UpdateCropWaste(Long id, CropWaste cropWaste) {

        throw new UnsupportedOperationException("Unimplemented method 'UpdateCropWaste'");
    }

    @Override
    public List<CropWaste> getAllCropWaste() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCropWaste'");
    }

    @Override
    public CropWaste getCropWasteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCropWasteById'");
    }

    @Override
    public CropWaste findCropByName(String cropName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCropByName'");
    }

    @Override
    public void deleteCropWaste(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCropWaste'");
    }

    @Override
    public List<CropWaste> findCropWasteByUser(User user) {

        return cropWasteRepository.findByUser(user.getId());
    }

    @Override
    public List<CropWasteResponse> findCropWasteByUserResponse(User user) {
        List<CropWaste> cropWastes = cropWasteRepository.findByUser(user.getId());

        // Initialize total quantities for each crop type
        int riceHuskTotal = 0;
        int wheatStrawTotal = 0;
        int cornCobsTotal = 0;
        int tobaccoCropTotal = 0;
        int cottonTotal = 0;
        int sugarcaneBagasseTotal = 0;

        // Calculate the total quantities
        for (CropWaste cropWaste : cropWastes) {
            switch (cropWaste.getCropName()) {
                case "Rice Husk":
                    riceHuskTotal += cropWaste.getQuantity();
                    break;
                case "Wheat Straw":
                    wheatStrawTotal += cropWaste.getQuantity();
                    break;
                case "Corn Cobs":
                    cornCobsTotal += cropWaste.getQuantity();
                    break;
                case "Tobacco Crop Residues":
                    tobaccoCropTotal += cropWaste.getQuantity();
                    break;
                case "Cotton Stalks and Leaves":
                    cottonTotal += cropWaste.getQuantity();
                    break;
                case "Sugarcane Bagasse":
                    sugarcaneBagasseTotal += cropWaste.getQuantity();
                    break;
                default:
                    // Handle other cases if needed
                    break;
            }
        }

        // Create the response list
        List<CropWasteResponse> cropWasteResponses = new ArrayList<>();

        // Add each crop waste response to the list, even if the total is zero
        cropWasteResponses.add(new CropWasteResponse("Rice Husk", riceHuskTotal));
        cropWasteResponses.add(new CropWasteResponse("Wheat Straw", wheatStrawTotal));
        cropWasteResponses.add(new CropWasteResponse("Corn Cobs", cornCobsTotal));
        cropWasteResponses.add(new CropWasteResponse("Tobacco Crop Residues", tobaccoCropTotal));
        cropWasteResponses.add(new CropWasteResponse("Cotton Stalks and Leaves", cottonTotal));
        cropWasteResponses.add(new CropWasteResponse("Sugarcane Bagasse", sugarcaneBagasseTotal));

        return cropWasteResponses;
    }

}
