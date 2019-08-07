package com.genius.services;

import com.genius.domain.purposes.Purpose;
import com.genius.repositories.PurposeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("purposeService")
public class PurposeService {
    private PurposeRepository purposeRepository;

    @Autowired
    public PurposeService(PurposeRepository purposeRepository) {
        this.purposeRepository = purposeRepository;
    }

    public Purpose createPurpose(Purpose purpose) {
        return purposeRepository.save(purpose);
    }

    public List<Purpose> getPurposes() {
        return purposeRepository.findAll();
    }
}
