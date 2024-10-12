package com.example.asmflutter.controller;
import com.example.asmflutter.dtos.PlaceDTO;
import com.example.asmflutter.dtos.ResponseObject;
import com.example.asmflutter.service.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/place")
public class PlaceController {
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }
    @CrossOrigin(origins = "http://localhost:59877")
    @GetMapping("")
    ResponseEntity<ResponseObject> getAll() {
        try {
            List<PlaceDTO> list = placeService.getAll();
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(true, 200, "Success", list)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject(true, 400, "Bad Request", "")
            );
        }
    }
}