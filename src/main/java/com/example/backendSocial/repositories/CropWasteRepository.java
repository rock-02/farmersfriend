package com.example.backendSocial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backendSocial.Entity.CropWaste;

@Repository
public interface CropWasteRepository extends JpaRepository<CropWaste, Long> {

    CropWaste findByCropName(String cropName);

    @Query("SELECT c FROM CropWaste c WHERE c.user.id = :userId")   
    java.util.List<CropWaste> findByUser(Long userId);


}
