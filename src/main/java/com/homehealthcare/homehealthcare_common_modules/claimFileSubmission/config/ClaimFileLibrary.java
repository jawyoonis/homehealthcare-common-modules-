package com.homehealthcare.homehealthcare_common_modules.claimFileSubmission.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
@ConfigurationProperties(prefix = "file-claim.library")
@Data
public class ClaimFileLibrary {
    private String isaAuthInfoQualifier;
    private String isaAuthInfo;
    private String isaSecurityInfoQualifier;
    private String isaSecurityInfo;
    private List<String> isaInterchangeIdQualifiers;
    private String isaInterchangeSenderId;
    private String isaInterchangeReceiverId;
    private String gsFunctionalIdentifierCode;
    private String gsApplicationSenderCode;
    private String gsApplicationReceiverCode;
    private String submitterName;
    private List<String> submitterContactEmails;
    private String receiverName;
}

