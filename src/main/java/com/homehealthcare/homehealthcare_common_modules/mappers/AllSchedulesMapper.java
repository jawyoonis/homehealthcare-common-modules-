//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.ScheduleDisplayDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.Schedule;
//import org.mapstruct.*;
//import org.mapstruct.factory.Mappers;
//
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//
//@Mapper(
//        componentModel = "spring",
//        uses = {ClientMapper.class, EmployeeMapper.class},
//        unmappedTargetPolicy = ReportingPolicy.IGNORE
//)
//public interface AllSchedulesMapper {
//    AllSchedulesMapper INSTANCE = Mappers.getMapper(AllSchedulesMapper.class);
//
//    // -------------------------------
//    // 1. Mapping Entity to Display DTO with Per-Date Data
//    // -------------------------------
//    @Mapping(source = "client.clientId", target = "clientId")
//    @Mapping(source = "client.firstName", target = "clientFirstName")
//    @Mapping(source = "client.lastName", target = "clientLastName")
//    @Mapping(source = "employee.id", target = "employeeId")
//    @Mapping(source = "employee.firstName", target = "employeeFirstName")
//    @Mapping(source = "employee.lastName", target = "employeeLastName")
//    @Mapping(source = "replacementEmployee.id", target = "replacementEmployeeId")
//    @Mapping(source = "replacementEmployee.firstName", target = "replacementEmployeeFirstName")
//    @Mapping(source = "replacementEmployee.lastName", target = "replacementEmployeeLastName")
//    // Exclude individual day clocked times and hours
//    // The @AfterMapping method will handle setting per-date fields
//    ScheduleDisplayDTO scheduleToScheduleDisplayDTO(Schedule schedule, @Context LocalDate date);
//
//    // -------------------------------
//    // 2. Custom Mapping for Per-Date Fields
//    // -------------------------------
//    @AfterMapping
//    default void setPerDateFields(Schedule schedule, @MappingTarget ScheduleDisplayDTO dto, @Context LocalDate date) {
//        if (date == null) {
//            // Handle null scheduleDate if necessary
//            dto.setClockedInTime(null);
//            dto.setClockedOutTime(null);
//            dto.setHours(null);
//            return;
//        }
//
//        DayOfWeek dayOfWeek = date.getDayOfWeek();
//        switch (dayOfWeek) {
//            case MONDAY -> {
//                dto.setClockedInTime(schedule.getMondayClockedInTime() != null ? schedule.getMondayClockedInTime().toString() : null);
//                dto.setClockedOutTime(schedule.getMondayClockedOutTime() != null ? schedule.getMondayClockedOutTime().toString() : null);
//                dto.setHours(schedule.getMondayHours());
//            }
//            case TUESDAY -> {
//                dto.setClockedInTime(schedule.getTuesdayClockedInTime() != null ? schedule.getTuesdayClockedInTime().toString() : null);
//                dto.setClockedOutTime(schedule.getTuesdayClockedOutTime() != null ? schedule.getTuesdayClockedOutTime().toString() : null);
//                dto.setHours(schedule.getTuesdayHours());
//            }
//            case WEDNESDAY -> {
//                dto.setClockedInTime(schedule.getWednesdayClockedInTime() != null ? schedule.getWednesdayClockedInTime().toString() : null);
//                dto.setClockedOutTime(schedule.getWednesdayClockedOutTime() != null ? schedule.getWednesdayClockedOutTime().toString() : null);
//                dto.setHours(schedule.getWednesdayHours());
//            }
//            case THURSDAY -> {
//                dto.setClockedInTime(schedule.getThursdayClockedInTime() != null ? schedule.getThursdayClockedInTime().toString() : null);
//                dto.setClockedOutTime(schedule.getThursdayClockedOutTime() != null ? schedule.getThursdayClockedOutTime().toString() : null);
//                dto.setHours(schedule.getThursdayHours());
//            }
//            case FRIDAY -> {
//                dto.setClockedInTime(schedule.getFridayClockedInTime() != null ? schedule.getFridayClockedInTime().toString() : null);
//                dto.setClockedOutTime(schedule.getFridayClockedOutTime() != null ? schedule.getFridayClockedOutTime().toString() : null);
//                dto.setHours(schedule.getFridayHours());
//            }
//            case SATURDAY -> {
//                dto.setClockedInTime(schedule.getSaturdayClockedInTime() != null ? schedule.getSaturdayClockedInTime().toString() : null);
//                dto.setClockedOutTime(schedule.getSaturdayClockedOutTime() != null ? schedule.getSaturdayClockedOutTime().toString() : null);
//                dto.setHours(schedule.getSaturdayHours());
//            }
//            case SUNDAY -> {
//                dto.setClockedInTime(schedule.getSundayClockedInTime() != null ? schedule.getSundayClockedInTime().toString() : null);
//                dto.setClockedOutTime(schedule.getSundayClockedOutTime() != null ? schedule.getSundayClockedOutTime().toString() : null);
//                dto.setHours(schedule.getSundayHours());
//            }
//            default -> {
//                // Optional: Handle unexpected days
//                dto.setClockedInTime(null);
//                dto.setClockedOutTime(null);
//                dto.setHours(null);
//            }
//        }
//    }
//}