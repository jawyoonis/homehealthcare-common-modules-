package com.homehealthcare.homehealthcare_common_modules.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClaimConstants {

    public static final String ISA_AUTH_INFO_QUALIFIER = "00";
    public static final String ISA_SECURITY_INFO_QUALIFIER = "00";
    public static final String ISA_REPETITION_SEPARATOR = "^";
    public static final String ISA_CONTROL_VERSION = "00501";
    public static final String ISA_USAGE_INDICATOR = "P";
    public static final String GS_RESPONSIBLE_AGENCY_CODE = "X";
    public static final String GS_VERSION = "005010X222A1";
    public static final String ST_TRANSACTION_SET_ID = "837";
    public static final String ST_IMPLEMENTATION_REFERENCE = "005010X222A1";
    public static final String SUBSCRIBER_ENTITY_CODE = "41";
    public static final String SUBSCRIBER_ENTITY_TYPE_QUALIFIER = "2";
    public static final String SUBSCRIBER_ID_CODE_QUALIFIER = "46";
    public static final String SE_SEGMENT_COUNT = "10";
    public static final String GE_TRANSACTION_SETS = "1";
    public static final String IEA_FUNCTIONAL_GROUPS = "1";

    public static final String CURRENT_DATE = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    public static final String CURRENT_TIME = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmm"));
}

