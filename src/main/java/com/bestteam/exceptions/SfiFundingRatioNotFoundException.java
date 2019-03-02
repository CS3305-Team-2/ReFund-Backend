package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class SfiFundingRatioNotFoundException extends RuntimeException {
    public SfiFundingRatioNotFoundException(String sfiFundingRatioId) {
        super("SFI Funding Ratio ID " + sfiFundingRatioId + " not found.");
    }
}
