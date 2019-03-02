package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class AnnualReportNotFoundException extends RuntimeException {
    public AnnualReportNotFoundException(String annualReport) {
        super("Annual Report ID " + annualReport + " not found.");
    }
}
