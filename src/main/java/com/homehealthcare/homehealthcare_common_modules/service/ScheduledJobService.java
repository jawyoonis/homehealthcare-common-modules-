package com.homehealthcare.homehealthcare_common_modules.service;

import com.homehealthcare.homehealthcare_common_modules.dto.ScheduledJobDTO;

import java.util.List;

public interface ScheduledJobService {
    ScheduledJobDTO createScheduledJob(ScheduledJobDTO scheduledJobDTO);
    ScheduledJobDTO getScheduledJobById(Long id);
    List<ScheduledJobDTO> getAllScheduledJobs();
    ScheduledJobDTO updateScheduledJob(Long id, ScheduledJobDTO scheduledJobDTO);
    void deleteScheduledJob(Long id);
}