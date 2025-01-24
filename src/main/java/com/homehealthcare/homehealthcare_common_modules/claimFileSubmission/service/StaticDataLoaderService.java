package com.homehealthcare.homehealthcare_common_modules.claimFileSubmission.service;

import com.homehealthcare.homehealthcare_common_modules.claimFileSubmission.config.ClaimFileLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaticDataLoaderService {

    private final StaticDataLoader staticDataLoader;
    private final ClaimFileLibrary claimFileLibrary;

    @Autowired
    public StaticDataLoaderService(StaticDataLoader staticDataLoader, ClaimFileLibrary claimFileLibrary) {
        this.staticDataLoader = staticDataLoader;
        this.claimFileLibrary = claimFileLibrary;
    }
    public final ClaimFileLibrary getClaimFileLibrary() {
        return claimFileLibrary;
    }

    public final StaticDataLoader getStaticDataLoader() {
        return staticDataLoader;
    }

    public String getStaticData(String key) {
        switch (key) {
            // ISA Segment
            case "isaAuthInfoQualifier":
                return staticDataLoader.getIsaAuthInfoQualifier();
            case "isaAuthInfo":
                return staticDataLoader.getIsaAuthInfo();
            case "isaSecurityInfoQualifier":
                return staticDataLoader.getIsaSecurityInfoQualifier();
            case "isaSecurityInfo":
                return staticDataLoader.getIsaSecurityInfo();

            // GS Segment
            case "gsFunctionalIdentifierCode":
                return staticDataLoader.getGsFunctionalIdentifierCode();
            case "gsApplicationSenderCode":
                return staticDataLoader.getGsApplicationSenderCode();
            case "gsApplicationReceiverCode":
                return staticDataLoader.getGsApplicationReceiverCode();

            // Submitter Information
            case "submitterName":
                return staticDataLoader.getSubmitterName();
            case "receiverName":
                return staticDataLoader.getReceiverName();

            // Provider Information
            case "providerName":
                return staticDataLoader.getProvider().getName();
            case "providerNPI":
                return staticDataLoader.getProvider().getNpi();
            case "providerAddressLine":
                return staticDataLoader.getProvider().getAddress().getLine();
            case "providerCity":
                return staticDataLoader.getProvider().getAddress().getCity();
            case "providerState":
                return staticDataLoader.getProvider().getAddress().getState();
            case "providerZip":
                return staticDataLoader.getProvider().getAddress().getZip();

            // Payer Information
            case "payerName":
                return staticDataLoader.getPayer().getName();
            case "payerID":
                return staticDataLoader.getPayer().getId();

            // Default case for unmatched keys
            default:
                throw new IllegalArgumentException("Key not found in static data: " + key);
        }
    }
}
