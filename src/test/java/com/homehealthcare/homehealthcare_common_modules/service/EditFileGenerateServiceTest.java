package com.homehealthcare.homehealthcare_common_modules.service;

import com.homehealthcare.homehealthcare_common_modules.claimFileSubmission.config.ClaimFileLibrary;
import com.homehealthcare.homehealthcare_common_modules.claimFileSubmission.service.EdiFileGeneratorService;
import com.homehealthcare.homehealthcare_common_modules.claimFileSubmission.service.StaticDataLoaderService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EdiFileGeneratorServiceTest {

    @Mock
    private StaticDataLoaderService mockStaticDataLoaderService;

    @InjectMocks
    private EdiFileGeneratorService ediFileGeneratorService;

    private ClaimFileLibrary mockClaimFileLibrary;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        // Mock ClaimFileLibrary
        mockClaimFileLibrary = new ClaimFileLibrary();
        mockClaimFileLibrary.setIsaAuthInfo("ISA_AUTH_INFO");
        mockClaimFileLibrary.setIsaSecurityInfo("ISA_SECURITY_INFO");
        mockClaimFileLibrary.setIsaAuthInfoQualifier("00");
        mockClaimFileLibrary.setIsaSecurityInfoQualifier("00");
        mockClaimFileLibrary.setIsaInterchangeIdQualifiers(List.of("ZZ", "01"));
        mockClaimFileLibrary.setIsaInterchangeSenderId("SENDER_ID");
        mockClaimFileLibrary.setIsaInterchangeReceiverId("RECEIVER_ID");
        mockClaimFileLibrary.setGsFunctionalIdentifierCode("HC");
        mockClaimFileLibrary.setGsApplicationSenderCode("APP_SENDER_CODE");
        mockClaimFileLibrary.setGsApplicationReceiverCode("APP_RECEIVER_CODE");
        mockClaimFileLibrary.setSubmitterName("Submitter Organization");

        when(mockStaticDataLoaderService.getClaimFileLibrary()).thenReturn(mockClaimFileLibrary);
    }

    @Test
    void testGenerateISASegment() {
        String isaSegment = ediFileGeneratorService.generateISASegment();

        assertNotNull(isaSegment);
        assertTrue(isaSegment.startsWith("ISA*00*ISA_AUTH_INFO*00*ISA_SECURITY_INFO*ZZ*SENDER_ID"));
        assertTrue(isaSegment.contains("*01*RECEIVER_ID"));
    }

    @Test
    void testInitializeFileAndWriteSegments() throws IOException {
        String fileName = "test_edi_file.edi";

        ediFileGeneratorService.initializeFile(fileName, 1500.00);

        File file = new File(fileName);
        assertTrue(file.exists());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            String content = fileContent.toString();

            // Validate ISA and GS segments
            assertTrue(content.contains("ISA*00*ISA_AUTH_INFO"));
            assertTrue(content.contains("GS*HC*APP_SENDER_CODE*APP_RECEIVER_CODE"));
        }

        assertTrue(file.delete());
    }

    @Test
    void testWriteFooter() throws IOException {
        String fileName = "test_footer_file.edi";

        ediFileGeneratorService.initializeFile(fileName, 1000.00);
        ediFileGeneratorService.closeWriter();

        File file = new File(fileName);
        assertTrue(file.exists());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            String content = fileContent.toString();

            // Validate footer segments
            assertTrue(content.contains("SE*"));
            assertTrue(content.contains("GE*"));
            assertTrue(content.contains("IEA*"));
        }

        assertTrue(file.delete());
    }

    @Test
    void testGenerateControlNumber() {
        String controlNumber = ediFileGeneratorService.generateControlNumber();
        assertNotNull(controlNumber);
        assertEquals(9, controlNumber.length());
        assertTrue(controlNumber.matches("\\d{9}"));
    }
}
