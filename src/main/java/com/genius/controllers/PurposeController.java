package com.genius.controllers;

import com.genius.domain.dto.PurposeDTO;
import com.genius.domain.purposes.Purpose;
import com.genius.services.PurposeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/purposes")
public class PurposeController {
    private PurposeService purposeService;
    private ModelMapper modelMapper;

    @Autowired
    public PurposeController(PurposeService purposeService, ModelMapper modelMapper) {
        this.purposeService = purposeService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseBody
    Purpose createPurpose(@RequestBody PurposeDTO purpose) {
        return purposeService.createPurpose(modelMapper.map(purpose, Purpose.class));
    }

    @GetMapping
    public ResponseEntity<List<Purpose>> getPurposes() {
        return ResponseEntity.ok(purposeService.getPurposes());
    }
}
