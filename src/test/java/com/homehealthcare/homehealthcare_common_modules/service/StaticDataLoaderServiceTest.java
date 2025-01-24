package com.homehealthcare.homehealthcare_common_modules.service;

import com.homehealthcare.homehealthcare_common_modules.claimFileSubmission.config.ClaimFileLibrary;
import com.homehealthcare.homehealthcare_common_modules.claimFileSubmission.service.StaticDataLoader;
import com.homehealthcare.homehealthcare_common_modules.claimFileSubmission.service.StaticDataLoaderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StaticDataLoaderServiceTest {

    @Mock
    private StaticDataLoader mockStaticDataLoader;

    @Mock
    private ClaimFileLibrary mockClaimFileLibrary;

    @InjectMocks
    private StaticDataLoaderService staticDataLoaderService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        // Mock Provider and Address
        StaticDataLoader.Provider mockProvider = new StaticDataLoader.Provider();
        StaticDataLoader.Provider.Address mockAddress = new StaticDataLoader.Provider.Address();
        mockProvider.setName("Provider Organization");
        mockProvider.setNpi("PROVIDER_NPI");
        mockAddress.setLine("123 Main St");
        mockAddress.setCity("CityName");
        mockAddress.setState("StateCode");
        mockAddress.setZip("12345");
        mockProvider.setAddress(mockAddress);

        // Mock Payer
        StaticDataLoader.Payer mockPayer = new StaticDataLoader.Payer();
        mockPayer.setName("Payer Organization");
        mockPayer.setId("PAYER_ID");

        // Mock StaticDataLoader behavior
        when(mockStaticDataLoader.getIsaAuthInfoQualifier()).thenReturn("00");
        when(mockStaticDataLoader.getIsaAuthInfo()).thenReturn("          ");
        when(mockStaticDataLoader.getIsaSecurityInfoQualifier()).thenReturn("00");
        when(mockStaticDataLoader.getIsaSecurityInfo()).thenReturn("          ");
        when(mockStaticDataLoader.getGsFunctionalIdentifierCode()).thenReturn("HC");
        when(mockStaticDataLoader.getGsApplicationSenderCode()).thenReturn("APP_SENDER_CODE");
        when(mockStaticDataLoader.getGsApplicationReceiverCode()).thenReturn("APP_RECEIVER_CODE");
        when(mockStaticDataLoader.getProvider()).thenReturn(mockProvider);
        when(mockStaticDataLoader.getPayer()).thenReturn(mockPayer);

        // Mock ClaimFileLibrary behavior
        when(mockClaimFileLibrary.getIsaAuthInfoQualifier()).thenReturn("01");
    }

    @Test
    void testStaticDataLoaderValues() {
        // ISA Segment assertions
        assertEquals("00", staticDataLoaderService.getStaticData("isaAuthInfoQualifier"));
        assertEquals("          ", staticDataLoaderService.getStaticData("isaAuthInfo"));
        assertEquals("00", staticDataLoaderService.getStaticData("isaSecurityInfoQualifier"));
        assertEquals("          ", staticDataLoaderService.getStaticData("isaSecurityInfo"));

        // GS Segment assertions
        assertEquals("HC", staticDataLoaderService.getStaticData("gsFunctionalIdentifierCode"));
        assertEquals("APP_SENDER_CODE", staticDataLoaderService.getStaticData("gsApplicationSenderCode"));
        assertEquals("APP_RECEIVER_CODE", staticDataLoaderService.getStaticData("gsApplicationReceiverCode"));

        // Provider Information assertions
        assertEquals("Provider Organization", staticDataLoaderService.getStaticData("providerName"));
        assertEquals("PROVIDER_NPI", staticDataLoaderService.getStaticData("providerNPI"));
        assertEquals("123 Main St", staticDataLoaderService.getStaticData("providerAddressLine"));
        assertEquals("CityName", staticDataLoaderService.getStaticData("providerCity"));
        assertEquals("StateCode", staticDataLoaderService.getStaticData("providerState"));
        assertEquals("12345", staticDataLoaderService.getStaticData("providerZip"));

        // Payer Information assertions
        assertEquals("Payer Organization", staticDataLoaderService.getStaticData("payerName"));
        assertEquals("PAYER_ID", staticDataLoaderService.getStaticData("payerID"));
    }

    @Test
    void testClaimFileLibraryValues() {
        // Ensure ClaimFileLibrary values are accessible
        assertEquals("01", staticDataLoaderService.getClaimFileLibrary().getIsaAuthInfoQualifier());
    }

    @Test
    void testProviderAddressDetails() {
        // Verify nested provider address details
        StaticDataLoader.Provider provider = mockStaticDataLoader.getProvider();
        assertNotNull(provider);
        StaticDataLoader.Provider.Address address = provider.getAddress();
        assertNotNull(address);

        assertEquals("123 Main St", address.getLine());
        assertEquals("CityName", address.getCity());
        assertEquals("StateCode", address.getState());
        assertEquals("12345", address.getZip());
    }

    @Test
    void testExceptionForInvalidKey() {
        // Verify IllegalArgumentException for invalid key
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                staticDataLoaderService.getStaticData("invalidKey")
        );
        assertEquals("Key not found in static data: invalidKey", exception.getMessage());
    }

    @Test
    void testNullProviderOrPayer() {
        // Simulate null provider or payer
        when(mockStaticDataLoader.getProvider()).thenReturn(null);
        when(mockStaticDataLoader.getPayer()).thenReturn(null);

        // Assertions for null values
        assertThrows(NullPointerException.class, () -> staticDataLoaderService.getStaticData("providerName"));
        assertThrows(NullPointerException.class, () -> staticDataLoaderService.getStaticData("payerName"));
    }

    @Test
    void testSubmitterDetails() {
        // Mock submitter details
        when(mockStaticDataLoader.getSubmitterName()).thenReturn("Submitter Organization");
        assertEquals("Submitter Organization", staticDataLoaderService.getStaticData("submitterName"));
    }

    @Test
    void testReceiverDetails() {
        // Mock receiver details
        when(mockStaticDataLoader.getReceiverName()).thenReturn("Receiver Organization");
        assertEquals("Receiver Organization", staticDataLoaderService.getStaticData("receiverName"));
    }

    @Test
    void testIsaInterchangeIdQualifiers() {
        // Mock ISA Interchange ID qualifiers
        when(mockStaticDataLoader.getIsaInterchangeIdQualifiers()).thenReturn(List.of("ZZ", "01", "08"));
        assertEquals(List.of("ZZ", "01", "08"), mockStaticDataLoader.getIsaInterchangeIdQualifiers());
    }
}
