package com.homehealthcare.homehealthcare_common_modules.service;


import com.homehealthcare.homehealthcare_common_modules.dto.ClientDTO;
import com.homehealthcare.homehealthcare_common_modules.dto.GeoRangeDTO;

import java.util.List;

public interface ClientService {
    ClientDTO findClientById(Long clientId);
    ClientDTO findClientByIdNumber(String idNumber);
    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO updateClient(Long clientId, ClientDTO clientDTO);
    void deleteClient(Long clientId);
    void deleteClients(List<Long> clientIds);
    List<ClientDTO> getAllClients();
    ClientDTO findClientsByLastName(String lastName);
    ClientDTO findClientsByFirstName(String firstName);
    ClientDTO findClientsByEmail(String email);
    List<ClientDTO> findClientsByAddress(String address);
    List<ClientDTO> findClientsByZipcode(String zipcode);
    List<ClientDTO> findClientsInGeoRange(GeoRangeDTO geoRangeDTO);
}