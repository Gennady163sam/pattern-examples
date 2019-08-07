package com.genius.controllers;

import com.genius.domain.purposes.Purpose;
import com.genius.services.PurposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/purposes")
public class PurposeController {
    private PurposeService purposeService;

    @Autowired
    public PurposeController(PurposeService purposeService) {
        this.purposeService = purposeService;
    }

    @PostMapping
    @ResponseBody
    Purpose createPurpose(@RequestBody Purpose purpose) {
        return purposeService.createPurpose(purpose);
    }

    @GetMapping
    public ResponseEntity<List<Purpose>> getPurposes() {
        return ResponseEntity.ok(purposeService.getPurposes());
    }
}
