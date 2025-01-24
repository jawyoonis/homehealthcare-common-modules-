//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.EVVVisitTimesheetDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.EVVVisitTimesheet;
//import com.homehealthcare.homehealthcare_common_modules.enums.VerificationMethod;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
//import org.mapstruct.factory.Mappers;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring",
//        uses = {
//                DeviceInfoMapper.class
//        })
//public interface EVVVisitTimesheetMapper {
//
//    EVVVisitTimesheetMapper INSTANCE = Mappers.getMapper(EVVVisitTimesheetMapper.class);
//
//    @Mapping(target = "verified", expression = "java(evvVisitTimesheet.isVerified())")
//    @Mapping(target = "clientId", source = "client.clientId")
//    @Mapping(target = "caregiverId", source = "caregiver.id")
//    @Mapping(target = "scheduleId", source = "schedule.id")
//    @Mapping(target = "clockInDeviceInfo", source = "clockInDeviceInfo")
//    @Mapping(target = "clockOutDeviceInfo", source = "clockOutDeviceInfo")
//    @Mapping(target = "verificationMethod", source = "verificationMethod", qualifiedByName = "verificationMethodToString")
//    EVVVisitTimesheetDTO toDTO(EVVVisitTimesheet evvVisitTimesheet);
//
//    @Mapping(target = "client.clientId", source = "clientId")
//    @Mapping(target = "caregiver.id", source = "caregiverId")
//    @Mapping(target = "schedule.id", source = "scheduleId")
//    @Mapping(target = "clockInDeviceInfo", source = "clockInDeviceInfo")
//    @Mapping(target = "clockOutDeviceInfo", source = "clockOutDeviceInfo")
//    @Mapping(target = "verificationMethod", source = "verificationMethod", qualifiedByName = "stringToVerificationMethod")
//    EVVVisitTimesheet toEntity(EVVVisitTimesheetDTO evvVisitTimesheetDTO);
//
//    List<EVVVisitTimesheetDTO> toDtoList(List<EVVVisitTimesheet> timesheets);
//
//    @Named("verificationMethodToString")
//    default String verificationMethodToString(VerificationMethod verificationMethod) {
//        return verificationMethod != null ? verificationMethod.name() : null;
//    }
//
//    @Named("stringToVerificationMethod")
//    default VerificationMethod stringToVerificationMethod(String verificationMethod) {
//        return verificationMethod != null ? VerificationMethod.valueOf(verificationMethod) : null;
//    }
//}