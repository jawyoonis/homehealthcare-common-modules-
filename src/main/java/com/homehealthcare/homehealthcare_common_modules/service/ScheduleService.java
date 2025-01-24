package com.homehealthcare.homehealthcare_common_modules.service;
import com.homehealthcare.homehealthcare_common_modules.dto.DailyScheduleDTO;
import com.homehealthcare.homehealthcare_common_modules.dto.ScheduleDTO;
import com.homehealthcare.homehealthcare_common_modules.dto.ScheduleDisplayDTO;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    ScheduleDTO findScheduleById(Long scheduleId);
    ScheduleDTO createSchedule(ScheduleDTO scheduleDTO);
    ScheduleDTO updateSchedule(Long scheduleId, ScheduleDTO scheduleDTO);
    void deleteSchedule(Long scheduleId);
    void deleteSchedules(List<Long> scheduleIds);
    List<ScheduleDTO> getAllSchedules();

    // Custom retrieval methods
    List<ScheduleDTO> findSchedulesByEmployeeId(Long employeeId);
    List<ScheduleDTO> findSchedulesByReplacementEmployeeId(Long replacementEmployeeId);
    List<ScheduleDTO> findSchedulesByClientId(Long clientId);
    List<ScheduleDTO> findSchedulesByDateRange(LocalDate startDate, LocalDate endDate);
    List<DailyScheduleDTO> findSchedulesByDate(LocalDate scheduleDate);
    DailyScheduleDTO updateDailySchedule(Long scheduleId, LocalDate date, DailyScheduleDTO dailyScheduleDTO);
    List<ScheduleDisplayDTO> getAllSchedulesForDisplay();
}
