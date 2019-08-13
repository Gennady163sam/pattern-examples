package com.genius.controllers;

import com.genius.domain.dto.PurposeDTO;
import com.genius.domain.purposes.Purpose;
import com.genius.domain.transfer.Create;
import com.genius.domain.transfer.Update;
import com.genius.exceptions.ApiException;
import com.genius.services.PurposeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<Purpose> createPurpose(@Validated(Create.class) @RequestBody PurposeDTO purpose) {
        return ResponseEntity.ok(purposeService.createPurpose(modelMapper.map(purpose, Purpose.class)));
    }

    @GetMapping
    public ResponseEntity<List<Purpose>> getPurposes() {
        return ResponseEntity.ok(purposeService.getPurposes());
    }

    @DeleteMapping("/{purposeId}")
    public void deletePurpose(@PathVariable Long purposeId) {
        purposeService.deletePurpose(purposeId);
    }

    @PutMapping
    public ResponseEntity<Purpose> updatePurpose(@Validated(Update.class)@RequestBody PurposeDTO purpose) {
        return ResponseEntity.ok(purposeService.updatePurpose(modelMapper.map(purpose, Purpose.class)));
    }

    @GetMapping("/{purposeId}")
    public ResponseEntity<Purpose> getPurposeById(@PathVariable Long purposeId) {
        return ResponseEntity.ok(purposeService.getById(purposeId).<ApiException>orElseThrow(() -> {throw new ApiException(HttpStatus.BAD_REQUEST);}));
    }
}
