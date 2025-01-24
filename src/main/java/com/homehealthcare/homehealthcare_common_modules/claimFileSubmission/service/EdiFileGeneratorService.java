package com.homehealthcare.homehealthcare_common_modules.claimFileSubmission.service;

import com.homehealthcare.homehealthcare_common_modules.claimFileSubmission.config.ClaimFileLibrary;
import com.homehealthcare.homehealthcare_common_modules.utils.ClaimConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class EdiFileGeneratorService {

    private static final int FIELD_LENGTH = 15; // Standard length for ID fields
    private BufferedWriter currentBufferedWriter;
    private String currentFileName;
    private int currentFileNumber = 0;

    private final StaticDataLoaderService staticDataLoaderService;

    @Autowired
    public EdiFileGeneratorService(StaticDataLoaderService staticDataLoaderService) {
        this.staticDataLoaderService = staticDataLoaderService;
    }

    public void initializeFile(String fileName, Double totalClaimSum) throws IOException {
        validateInput(fileName, totalClaimSum);

        this.currentFileName = fileName;
        this.currentBufferedWriter = new BufferedWriter(new FileWriter(currentFileName));
        currentFileNumber++;

        // Write segments in sequence
        writeSegment(generateISASegment());
        writeSegment(generateGSSegment());
        writeSegment(generateSTSegment());
        writeSegment(generateSubscriberSegment(totalClaimSum));
    }

        public String generateISASegment() {
            ClaimFileLibrary claimFileLibrary = staticDataLoaderService.getClaimFileLibrary();

            String formattedSenderId = padField(claimFileLibrary.getIsaInterchangeSenderId(), 15);
            String formattedReceiverId = padField(claimFileLibrary.getIsaInterchangeReceiverId(), 15);

            return String.format("ISA*%s*%s*%s*%s*%s*%s*%s*%s*%s*%s*%s*%s*%s*%s~",
                    ClaimConstants.ISA_AUTH_INFO_QUALIFIER,
                    claimFileLibrary.getIsaAuthInfo(),
                    ClaimConstants.ISA_SECURITY_INFO_QUALIFIER,
                    claimFileLibrary.getIsaSecurityInfo(),
                    claimFileLibrary.getIsaInterchangeIdQualifiers().get(0),
                    formattedSenderId,
                    claimFileLibrary.getIsaInterchangeIdQualifiers().get(1),
                    formattedReceiverId,
                    ClaimConstants.CURRENT_DATE,
                    ClaimConstants.CURRENT_TIME,
                    ClaimConstants.ISA_REPETITION_SEPARATOR,
                    ClaimConstants.ISA_CONTROL_VERSION,
                    generateControlNumber(),
                    ClaimConstants.ISA_USAGE_INDICATOR
            );
    }



    private String generateGSSegment() {
        ClaimFileLibrary claimFileLibrary = staticDataLoaderService.getClaimFileLibrary();

        return String.format("GS*%s*%s*%s*%s*%s*%s*%s*%s~",
                claimFileLibrary.getGsFunctionalIdentifierCode(),
                claimFileLibrary.getGsApplicationSenderCode(),
                claimFileLibrary.getGsApplicationReceiverCode(),
                ClaimConstants.CURRENT_DATE,
                ClaimConstants.CURRENT_TIME,
                generateControlNumber(),
                ClaimConstants.GS_RESPONSIBLE_AGENCY_CODE,
                ClaimConstants.GS_VERSION
        );
    }

    private String generateSTSegment() {
        return String.format("ST*%s*%s*%s~",
                ClaimConstants.ST_TRANSACTION_SET_ID,
                generateControlNumber(),
                ClaimConstants.ST_IMPLEMENTATION_REFERENCE
        );
    }

    private String generateSubscriberSegment(Double totalClaimSum) {
        ClaimFileLibrary claimFileLibrary = staticDataLoaderService.getClaimFileLibrary();

        return String.format("NM1*%s*%s*%s*%s*%s*%s*%s~",
                ClaimConstants.SUBSCRIBER_ENTITY_CODE,
                ClaimConstants.SUBSCRIBER_ENTITY_TYPE_QUALIFIER,
                claimFileLibrary.getSubmitterName(),
                "", // First Name
                "", // Middle Name
                ClaimConstants.SUBSCRIBER_ID_CODE_QUALIFIER,
                totalClaimSum
        );
    }

    private void writeFooter() throws IOException {
        writeSegment(String.format("SE*%s*%s~", ClaimConstants.SE_SEGMENT_COUNT, generateControlNumber()));
        writeSegment(String.format("GE*%s*%s~", ClaimConstants.GE_TRANSACTION_SETS, generateControlNumber()));
        writeSegment(String.format("IEA*%s*%s~", ClaimConstants.IEA_FUNCTIONAL_GROUPS, generateControlNumber()));
    }

    private void writeSegment(String segment) throws IOException {
        if (currentBufferedWriter != null) {
            currentBufferedWriter.write(segment + "\n");
            currentBufferedWriter.flush();
        }
    }

    public void closeWriter() throws IOException {
        if (currentBufferedWriter != null) {
            writeFooter();
            currentBufferedWriter.close();
        }
    }

    public String generateControlNumber() {
        return String.format("%09d", (int) (Math.random() * 1000000000));
    }

    private void validateInput(String fileName, Double totalClaimSum) {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name must not be null or empty.");
        }
        if (totalClaimSum == null || totalClaimSum <= 0) {
            throw new IllegalArgumentException("Total claim sum must be greater than zero.");
        }
    }

    private String padField(String value, int length) {
        return String.format("%-" + length + "s", value != null ? value : "").substring(0, length);
    }
}
