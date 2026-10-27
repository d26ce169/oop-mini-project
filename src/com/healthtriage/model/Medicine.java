package com.healthtriage.model;

public class Medicine extends MedicalRecommendation {
    private final String dosageAdvice;
    private final boolean isOTC;

    public Medicine(String name, String purpose, String dosageAdvice, boolean isOTC) {
        super(name, purpose);
        this.dosageAdvice = dosageAdvice;
        this.isOTC = isOTC;
    }

    public String getDosageAdvice() {
        return dosageAdvice;
    }

    public boolean isOTC() {
        return isOTC;
    }

    @Override
    public void printSummary() {
        System.out.printf("  • [Medicine] %s (%s) - %s | Advice: %s%n",
                getName(), isOTC ? "OTC" : "Prescription Required", getPurpose(), dosageAdvice);
    }
}
