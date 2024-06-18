package com.example.backendSocial.services;

import java.util.List;
import com.example.backendSocial.Entity.CropWaste;
import com.example.backendSocial.Entity.User;
import com.example.backendSocial.response.CropWasteResponse;

public interface CropWasterService {

    public CropWaste CreateCropWaste(CropWaste cropWaste, User user);

    public CropWaste UpdateCropWaste(Long id, CropWaste cropWaste);

    public List<CropWaste> getAllCropWaste();

    public CropWaste getCropWasteById(Long id);

    public CropWaste findCropByName(String cropName);

    public void deleteCropWaste(Long id);

    public List<CropWaste> findCropWasteByUser(User user);

    public List<CropWasteResponse> findCropWasteByUserResponse(User user);

}
