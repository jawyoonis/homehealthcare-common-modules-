//package com.homehealthcare.homehealthcare_common_modules.mappers;
//
//import com.homehealthcare.homehealthcare_common_modules.dto.ClientDTO;
//import com.homehealthcare.homehealthcare_common_modules.entity.Client;
//import org.mapstruct.*;
//import org.mapstruct.factory.Mappers;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
//public interface ClientMapper {
//    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
//
//    @Mapping(target = "clientId", source = "clientId")
//    ClientDTO clientToClientDTO(Client client);
//
//    @Mapping(target = "clientId", source = "clientId")
//    @Mapping(target = "clientPayrolls", ignore = true)
//    @Mapping(target = "clientEmployeeLinks", ignore = true)
//    Client clientDTOToClient(ClientDTO clientDTO);
//
//    List<ClientDTO> clientsToClientDTOs(List<Client> clients);
//
//    List<Client> clientDTOsToClients(List<ClientDTO> clientDTOs);
//
//    @Mapping(target = "clientId", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "clientPayrolls", ignore = true)
//    @Mapping(target = "clientEmployeeLinks", ignore = true)
//    void updateClientFromDTO(ClientDTO clientDTO, @MappingTarget Client client);
//}