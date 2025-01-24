//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.ClaimDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.Claim;
//import com.homehealthcare.homehealthcare_common_modules.enums.ClaimStatus;
//import org.mapstruct.*;
//
//@Mapper(componentModel = "spring",
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
//        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
//        imports = {ClaimStatus.class})
//public interface ClaimMapper {
//
//    @Mapping(target = "clientId", source = "client.clientId")
//    @Mapping(target = "status", source = "status", qualifiedByName = "statusToString")
//    ClaimDTO claimToClaimDTO(Claim claim);
//
//    @Mapping(target = "client.clientId", source = "clientId")
//    @Mapping(target = "status", source = "status", qualifiedByName = "stringToStatus")
//    Claim claimDTOToClaim(ClaimDTO claimDTO);
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "client", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "version", ignore = true)
//    @Mapping(target = "status", source = "status", qualifiedByName = "stringToStatus")
//    void updateClaimFromDTO(ClaimDTO claimDTO, @MappingTarget Claim claim);
//
//    @Named("stringToStatus")
//    default ClaimStatus stringToStatus(String status) {
//        if (status == null) {
//            return ClaimStatus.DRAFT;
//        }
//        return ClaimStatus.valueOf(status);
//    }
//
//    @Named("statusToString")
//    default String statusToString(ClaimStatus status) {
//        if (status == null) {
//            return null;
//        }
//        return status.name();
//    }
//}