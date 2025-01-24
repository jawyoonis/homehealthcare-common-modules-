//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.ReplacementDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.Client;
//import com.homehealthcare.homehealthcare_common_modules.entity.Employee;
//import com.homehealthcare.homehealthcare_common_modules.entity.Replacement;
//import org.mapstruct.*;
//
//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
//public interface ReplacementMapper {
//    @Mapping(source = "originalCaregiver.id", target = "originalCaregiverId")
//    @Mapping(source = "replacementCaregiver.id", target = "replacementCaregiverId")
//    @Mapping(source = "client.clientId", target = "clientId")
//    ReplacementDTO toDto(Replacement replacement);
//
//    @Mapping(target = "originalCaregiver", ignore = true)
//    @Mapping(target = "replacementCaregiver", ignore = true)
//    @Mapping(target = "client", ignore = true)
//    Replacement toEntity(ReplacementDTO replacementDTO);
//
//    @Mapping(target = "originalCaregiver", ignore = true)
//    @Mapping(target = "replacementCaregiver", ignore = true)
//    @Mapping(target = "client", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    void updateFromDto(ReplacementDTO replacementDTO, @MappingTarget Replacement replacement);
//
//    @AfterMapping
//    default void setRelations(@MappingTarget Replacement replacement, ReplacementDTO dto) {
//        if (dto.getOriginalCaregiverId() != null) {
//            Employee originalCaregiver = new Employee();
//            originalCaregiver.setId(dto.getOriginalCaregiverId());
//            replacement.setOriginalCaregiver(originalCaregiver);
//        }
//
//        if (dto.getReplacementCaregiverId() != null) {
//            Employee replacementCaregiver = new Employee();
//            replacementCaregiver.setId(dto.getReplacementCaregiverId());
//            replacement.setReplacementCaregiver(replacementCaregiver);
//        }
//
//        if (dto.getClientId() != null) {
//            Client client = new Client();
//            client.setClientId(dto.getClientId());
//            replacement.setClient(client);
//        }
//    }
//}