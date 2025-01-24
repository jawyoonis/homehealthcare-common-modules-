//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.ScheduledJobDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.ScheduledJob;
//import org.mapstruct.*;
//
//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
//public interface ScheduledJobMapper {
//
//    ScheduledJobDTO scheduledJobToScheduledJobDTO(ScheduledJob scheduledJob);
//
//    @Mapping(target = "clientPayrolls", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    ScheduledJob scheduledJobDTOToScheduledJob(ScheduledJobDTO scheduledJobDTO);
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "clientPayrolls", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    void updateScheduledJobFromDTO(ScheduledJobDTO scheduledJobDTO, @MappingTarget ScheduledJob scheduledJob);
//}