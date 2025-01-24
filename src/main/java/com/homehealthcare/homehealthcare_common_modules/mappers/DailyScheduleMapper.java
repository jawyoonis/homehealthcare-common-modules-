//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.DailyScheduleDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.Schedule;
//import org.mapstruct.*;
//import org.mapstruct.factory.Mappers;
//
//import java.time.DayOfWeek;
//import java.time.LocalTime;
//
//@Mapper(componentModel = "spring", uses = {ClientMapper.class, EmployeeMapper.class})
//public interface DailyScheduleMapper {
//    DailyScheduleMapper INSTANCE = Mappers.getMapper(DailyScheduleMapper.class);
//
//    @Mapping(source = "client.clientId", target = "clientId")
//    @Mapping(source = "client.firstName", target = "clientFirstName")
//    @Mapping(source = "client.lastName", target = "clientLastName")
//    @Mapping(source = "employee.id", target = "employeeId")
//    @Mapping(source = "employee.firstName", target = "employeeFirstName")
//    @Mapping(source = "employee.lastName", target = "employeeLastName")
//    @Mapping(source = "replacementEmployee.id", target = "replacementEmployeeId")
//    @Mapping(source = "replacementEmployee.firstName", target = "replacementEmployeeFirstName")
//    @Mapping(source = "replacementEmployee.lastName", target = "replacementEmployeeLastName")
//    @Mapping(target = "hours", expression = "java(getHoursForDay(schedule, date.getDayOfWeek()))")
//    @Mapping(target = "clockedInTime", expression = "java(getClockedInTimeForDay(schedule, date.getDayOfWeek()))")
//    @Mapping(target = "clockedOutTime", expression = "java(getClockedOutTimeForDay(schedule, date.getDayOfWeek()))")
//    DailyScheduleDTO scheduleToDailyScheduleDTO(Schedule schedule, @Context java.time.LocalDate date);
//
//    @AfterMapping
//    default void setScheduleDate(@MappingTarget DailyScheduleDTO dailyScheduleDTO, @Context java.time.LocalDate date) {
//        dailyScheduleDTO.setScheduleDate(date);
//    }
//
//    default Double getHoursForDay(Schedule schedule, DayOfWeek dayOfWeek) {
//        return switch (dayOfWeek) {
//            case MONDAY -> schedule.getMondayHours();
//            case TUESDAY -> schedule.getTuesdayHours();
//            case WEDNESDAY -> schedule.getWednesdayHours();
//            case THURSDAY -> schedule.getThursdayHours();
//            case FRIDAY -> schedule.getFridayHours();
//            case SATURDAY -> schedule.getSaturdayHours();
//            case SUNDAY -> schedule.getSundayHours();
//        };
//    }
//
//    default LocalTime getClockedInTimeForDay(Schedule schedule, DayOfWeek dayOfWeek) {
//        return switch (dayOfWeek) {
//            case MONDAY -> schedule.getMondayClockedInTime();
//            case TUESDAY -> schedule.getTuesdayClockedInTime();
//            case WEDNESDAY -> schedule.getWednesdayClockedInTime();
//            case THURSDAY -> schedule.getThursdayClockedInTime();
//            case FRIDAY -> schedule.getFridayClockedInTime();
//            case SATURDAY -> schedule.getSaturdayClockedInTime();
//            case SUNDAY -> schedule.getSundayClockedInTime();
//        };
//    }
//
//    default LocalTime getClockedOutTimeForDay(Schedule schedule, DayOfWeek dayOfWeek) {
//        return switch (dayOfWeek) {
//            case MONDAY -> schedule.getMondayClockedOutTime();
//            case TUESDAY -> schedule.getTuesdayClockedOutTime();
//            case WEDNESDAY -> schedule.getWednesdayClockedOutTime();
//            case THURSDAY -> schedule.getThursdayClockedOutTime();
//            case FRIDAY -> schedule.getFridayClockedOutTime();
//            case SATURDAY -> schedule.getSaturdayClockedOutTime();
//            case SUNDAY -> schedule.getSundayClockedOutTime();
//        };
//    }
//}