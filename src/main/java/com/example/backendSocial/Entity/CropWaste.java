package com.example.backendSocial.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CropWaste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cropName;

    private Integer quantity;

    private Date createdAt;

    private String status = "Pending";

    @ManyToOne
    private User user;

}
