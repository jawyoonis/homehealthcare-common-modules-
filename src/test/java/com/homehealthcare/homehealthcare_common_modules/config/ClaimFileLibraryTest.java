package com.homehealthcare.homehealthcare_common_modules.config;

import com.homehealthcare.homehealthcare_common_modules.claimFileSubmission.config.ClaimFileLibrary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ClaimFileLibrary.class)
@EnableConfigurationProperties(ClaimFileLibrary.class)
@ActiveProfiles("test")
@TestPropertySource(properties = {
        "file-claim.library.isa-auth-info-qualifier=00",
        "file-claim.library.isa-auth-info=ISA_AUTH_INFO",
        "file-claim.library.isa-security-info-qualifier=00",
        "file-claim.library.isa-security-info=ISA_SECURITY_INFO",
        "file-claim.library.isa-interchange-id-qualifiers[0]=ZZ",
        "file-claim.library.isa-interchange-id-qualifiers[1]=01",
        "file-claim.library.isa-interchange-sender-id=SENDER_ID",
        "file-claim.library.isa-interchange-receiver-id=RECEIVER_ID",
        "file-claim.library.gs-functional-identifier-code=HC",
        "file-claim.library.gs-application-sender-code=APP_SENDER_CODE",
        "file-claim.library.gs-application-receiver-code=APP_RECEIVER_CODE",
        "file-claim.library.submitter-name=Submitter Organization"
})
class ClaimFileLibraryTest {

    @Autowired
    private ClaimFileLibrary claimFileLibrary;

    @Test
    void testClaimFileLibraryBinding() {
        assertNotNull(claimFileLibrary);

        assertEquals("00", claimFileLibrary.getIsaAuthInfoQualifier());
        assertEquals("ISA_AUTH_INFO", claimFileLibrary.getIsaAuthInfo());
        assertEquals("00", claimFileLibrary.getIsaSecurityInfoQualifier());
        assertEquals("ISA_SECURITY_INFO", claimFileLibrary.getIsaSecurityInfo());
        assertEquals("ZZ", claimFileLibrary.getIsaInterchangeIdQualifiers().get(0));
        assertEquals("01", claimFileLibrary.getIsaInterchangeIdQualifiers().get(1));
        assertEquals("SENDER_ID", claimFileLibrary.getIsaInterchangeSenderId());
        assertEquals("RECEIVER_ID", claimFileLibrary.getIsaInterchangeReceiverId());
        assertEquals("HC", claimFileLibrary.getGsFunctionalIdentifierCode());
        assertEquals("APP_SENDER_CODE", claimFileLibrary.getGsApplicationSenderCode());
        assertEquals("APP_RECEIVER_CODE", claimFileLibrary.getGsApplicationReceiverCode());
        assertEquals("Submitter Organization", claimFileLibrary.getSubmitterName());
    }
}
