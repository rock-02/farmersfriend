package com.example.backendSocial.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CropWasteResponse {

    public String cropName;

    public Integer quantity;
}
