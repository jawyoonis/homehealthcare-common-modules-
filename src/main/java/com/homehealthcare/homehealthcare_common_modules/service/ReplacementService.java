package com.homehealthcare.homehealthcare_common_modules.service;

import com.homehealthcare.homehealthcare_common_modules.dto.ReplacementDTO;

import java.util.List;

public interface ReplacementService {
    ReplacementDTO createReplacement(ReplacementDTO replacementDTO);

    ReplacementDTO updateReplacement(Long id, ReplacementDTO replacementDTO);

    List<ReplacementDTO> getReplacementsForClient(Long clientId);

    void deleteReplacement(Long id);
}
