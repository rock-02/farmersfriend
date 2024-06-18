package com.example.backendSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendSocial.Entity.CropWaste;
import com.example.backendSocial.Entity.User;
import com.example.backendSocial.services.CropWasterService;
import com.example.backendSocial.services.UserService;

@RestController
@RequestMapping("/api")
public class CropController {

    @Autowired
    private UserService userService;

    @Autowired
    private CropWasterService cropWasterService;

    @PostMapping("/crops")
    public ResponseEntity<CropWaste> addCrop(@RequestBody CropWaste crop,
            @RequestHeader("Authorization") String token) {

        try {

            User user = userService.findUserByJwt(token);

            CropWaste savedCrop = cropWasterService.CreateCropWaste(crop, user);

            return new ResponseEntity<CropWaste>(savedCrop, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/crops")
    public ResponseEntity<?> getCrops(@RequestHeader("Authorization") String token) {

        try {

            User user = userService.findUserByJwt(token);

            return new ResponseEntity<>(cropWasterService.findCropWasteByUser(user), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/crops/user")
    public ResponseEntity<?> getCropsByUser(@RequestHeader("Authorization") String token) {

        try {

            User user = userService.findUserByJwt(token);

            return new ResponseEntity<>(cropWasterService.findCropWasteByUserResponse(user), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
