package com.healthtriage.model;

public class DiagnosticTest extends MedicalRecommendation {
    private final String sampleType;

    public DiagnosticTest(String name, String purpose, String sampleType) {
        super(name, purpose);
        this.sampleType = sampleType;
    }

    public String getSampleType() {
        return sampleType;
    }

    @Override
    public void printSummary() {
        System.out.printf("  • [Lab Report] %s (Sample: %s) - Purpose: %s%n",
                getName(), sampleType, getPurpose());
    }
}
