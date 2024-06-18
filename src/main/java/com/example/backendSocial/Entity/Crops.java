package com.example.backendSocial.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crops {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cropName;

    private String cropType;

    private String cropVariety;

    private String cropSeason;

    private String cropSoil;

    private String cropFertilizer;

    private String cropIrrigation;

    private String cropDisease;

    private String cropPesticide;

    private String cropHarvesting;

    private String cropClimate;

    private Integer rainFall;

    private String cropImage;

}
