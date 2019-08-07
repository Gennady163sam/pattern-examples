package com.genius.repositories;

import com.genius.domain.purposes.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurposeRepository extends JpaRepository<Purpose, Long> {
}
