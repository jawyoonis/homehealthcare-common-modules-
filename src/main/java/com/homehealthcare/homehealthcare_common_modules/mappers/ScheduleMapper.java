//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.ScheduleDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.Schedule;
//import org.mapstruct.*;
//import org.mapstruct.factory.Mappers;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring", uses = {ClientMapper.class, EmployeeMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
//public interface ScheduleMapper {
//    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);
//
//    // Mapping entity to DTO
//    @Mapping(source = "client.clientId", target = "clientId")
//    @Mapping(source = "client.firstName", target = "clientFirstName") // New Mapping
//    @Mapping(source = "client.lastName", target = "clientLastName")   // New Mapping
//    @Mapping(source = "employee.id", target = "employeeId")
//    @Mapping(source = "employee.firstName", target = "employeeFirstName") // New Mapping
//    @Mapping(source = "employee.lastName", target = "employeeLastName")   // New Mapping
//    @Mapping(source = "replacementEmployee.id", target = "replacementEmployeeId")
//    @Mapping(source = "replacementEmployee.firstName", target = "replacementEmployeeFirstName") // New Mapping
//    @Mapping(source = "replacementEmployee.lastName", target = "replacementEmployeeLastName")   // New Mapping
//    // Existing Mappings for clocked times and other fields
//    @Mapping(source = "mondayClockedInTime", target = "mondayClockedInTime")
//    @Mapping(source = "mondayClockedOutTime", target = "mondayClockedOutTime")
//    @Mapping(source = "tuesdayClockedInTime", target = "tuesdayClockedInTime")
//    @Mapping(source = "tuesdayClockedOutTime", target = "tuesdayClockedOutTime")
//    @Mapping(source = "wednesdayClockedInTime", target = "wednesdayClockedInTime")
//    @Mapping(source = "wednesdayClockedOutTime", target = "wednesdayClockedOutTime")
//    @Mapping(source = "thursdayClockedInTime", target = "thursdayClockedInTime")
//    @Mapping(source = "thursdayClockedOutTime", target = "thursdayClockedOutTime")
//    @Mapping(source = "fridayClockedInTime", target = "fridayClockedInTime")
//    @Mapping(source = "fridayClockedOutTime", target = "fridayClockedOutTime")
//    @Mapping(source = "saturdayClockedInTime", target = "saturdayClockedInTime")
//    @Mapping(source = "saturdayClockedOutTime", target = "saturdayClockedOutTime")
//    @Mapping(source = "sundayClockedInTime", target = "sundayClockedInTime")
//    @Mapping(source = "sundayClockedOutTime", target = "sundayClockedOutTime")
//    ScheduleDTO scheduleToScheduleDTO(Schedule schedule);
//
//    // Mapping DTO to entity, ignoring the ID for create operations
//    @Mapping(target = "id", ignore = true)
//    @Mapping(source = "clientId", target = "client.clientId")
//    @Mapping(source = "employeeId", target = "employee.id")
//    @Mapping(source = "replacementEmployeeId", target = "replacementEmployee.id")
//    // Existing Mappings for clocked times and other fields
//    @Mapping(source = "mondayClockedInTime", target = "mondayClockedInTime")
//    @Mapping(source = "mondayClockedOutTime", target = "mondayClockedOutTime")
//    @Mapping(source = "tuesdayClockedInTime", target = "tuesdayClockedInTime")
//    @Mapping(source = "tuesdayClockedOutTime", target = "tuesdayClockedOutTime")
//    @Mapping(source = "wednesdayClockedInTime", target = "wednesdayClockedInTime")
//    @Mapping(source = "wednesdayClockedOutTime", target = "wednesdayClockedOutTime")
//    @Mapping(source = "thursdayClockedInTime", target = "thursdayClockedInTime")
//    @Mapping(source = "thursdayClockedOutTime", target = "thursdayClockedOutTime")
//    @Mapping(source = "fridayClockedInTime", target = "fridayClockedInTime")
//    @Mapping(source = "fridayClockedOutTime", target = "fridayClockedOutTime")
//    @Mapping(source = "saturdayClockedInTime", target = "saturdayClockedInTime")
//    @Mapping(source = "saturdayClockedOutTime", target = "saturdayClockedOutTime")
//    @Mapping(source = "sundayClockedInTime", target = "sundayClockedInTime")
//    @Mapping(source = "sundayClockedOutTime", target = "sundayClockedOutTime")
//    Schedule scheduleDTOToSchedule(ScheduleDTO scheduleDTO);
//
//    List<ScheduleDTO> schedulesToScheduleDTOs(List<Schedule> schedules);
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(source = "clientId", target = "client.clientId")
//    @Mapping(source = "employeeId", target = "employee.id")
//    @Mapping(source = "replacementEmployeeId", target = "replacementEmployee.id")
//    // Existing Mappings for clocked times and other fields
//    @Mapping(source = "mondayClockedInTime", target = "mondayClockedInTime")
//    @Mapping(source = "mondayClockedOutTime", target = "mondayClockedOutTime")
//    @Mapping(source = "tuesdayClockedInTime", target = "tuesdayClockedInTime")
//    @Mapping(source = "tuesdayClockedOutTime", target = "tuesdayClockedOutTime")
//    @Mapping(source = "wednesdayClockedInTime", target = "wednesdayClockedInTime")
//    @Mapping(source = "wednesdayClockedOutTime", target = "wednesdayClockedOutTime")
//    @Mapping(source = "thursdayClockedInTime", target = "thursdayClockedInTime")
//    @Mapping(source = "thursdayClockedOutTime", target = "thursdayClockedOutTime")
//    @Mapping(source = "fridayClockedInTime", target = "fridayClockedInTime")
//    @Mapping(source = "fridayClockedOutTime", target = "fridayClockedOutTime")
//    @Mapping(source = "saturdayClockedInTime", target = "saturdayClockedInTime")
//    @Mapping(source = "saturdayClockedOutTime", target = "saturdayClockedOutTime")
//    @Mapping(source = "sundayClockedInTime", target = "sundayClockedInTime")
//    @Mapping(source = "sundayClockedOutTime", target = "sundayClockedOutTime")
//    void updateScheduleFromDTO(ScheduleDTO scheduleDTO, @MappingTarget Schedule schedule);
//}