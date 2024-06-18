package com.example.backendSocial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.backendSocial.Entity.Crops;

@Repository
public interface CropRepository extends JpaRepository<Crops, Long> {

    @Query("SELECT c FROM Crops c WHERE c.cropName LIKE %:query% OR c.cropSoil LIKE %:query% OR c.cropSeason LIKE %:query%")
    List<Crops> findByCropNameCropSoilCropSeason(@Param("query") String query);
}
