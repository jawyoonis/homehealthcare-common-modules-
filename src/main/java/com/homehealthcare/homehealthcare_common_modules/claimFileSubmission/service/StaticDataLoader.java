package com.homehealthcare.homehealthcare_common_modules.claimFileSubmission.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "file-claim")
@Data
public class StaticDataLoader {
    private String isaAuthInfo;
    private String isaSecurityInfo;
    private String isaAuthInfoQualifier; // Add this field
    private String isaSecurityInfoQualifier; // Add this field
    private List<String> isaInterchangeIdQualifiers;
    private String isaInterchangeSenderId;
    private String isaInterchangeReceiverId;
    private String gsFunctionalIdentifierCode;
    private String gsApplicationSenderCode;
    private String gsApplicationReceiverCode;
    private String submitterName;
    private List<String> submitterContactEmails;
    private String receiverName;
    private Provider provider;
    private Subscriber subscriber;
    private Payer payer;


    @Data
    public static class Provider {
        private String name;
        private String npi;
        private Address address;

        @Data
        public static class Address {
            private String line;
            private String city;
            private String state;
            private String zip;
        }
    }

    @Data
    public static class Subscriber {
        private String name;
        private String id;
        private Address address;

        @Data
        public static class Address {
            private String line1;
            private String city;
            private String state;
            private String zip;
        }
    }

    @Data
    public static class Payer {
        private String name;
        private String id;
    }
}
