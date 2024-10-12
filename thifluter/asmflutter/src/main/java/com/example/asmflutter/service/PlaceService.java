package com.example.asmflutter.service;

import com.example.asmflutter.dtos.PlaceDTO;
import com.example.asmflutter.entities.Place;
import com.example.asmflutter.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;

    public List<PlaceDTO> getAll() {
        List<Place> placeList = placeRepository.findAll();
        List<PlaceDTO> placeDTOList = new ArrayList<>();
        for (Place place: placeList) {
            PlaceDTO placeDTO = PlaceDTO.builder()
                    .id(place.getId())
                    .name(place.getName())
                    .star(place.getStar())
                    .image(place.getImage())
                    .build();
            placeDTOList.add(placeDTO);
        }
        return placeDTOList;
    }
}
