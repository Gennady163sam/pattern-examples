package com.genius.services;

import com.genius.domain.purposes.Purpose;
import com.genius.repositories.PurposeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Purpose> getById(Long purposeId) {
        return purposeRepository.findById(purposeId);
    }

    public Purpose updatePurpose(Purpose purpose) {
        return purposeRepository.save(prepareModel(purpose));
    }

    public void deletePurpose(Long purposeId) {
        getById(purposeId).ifPresent(p -> purposeRepository.delete(p));
    }

    public List<Purpose> getPurposes() {
        return purposeRepository.findAll();
    }

    private Purpose prepareModel(Purpose purpose) {
        purposeRepository.findById(purpose.getPurposeId()).ifPresent(currentPurpose -> {
            purpose.setDescription(purpose.getDescription() != null ? purpose.getDescription() : currentPurpose.getDescription());
            purpose.setRequirementDate(purpose.getRequirementDate() != null ? purpose.getRequirementDate() : currentPurpose.getRequirementDate());
            purpose.setStartDate(purpose.getStartDate() != null ? purpose.getStartDate() : currentPurpose.getStartDate());
        });
        return purpose;
    }
}