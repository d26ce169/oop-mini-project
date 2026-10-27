package com.healthtriage.model;

public abstract class MedicalRecommendation {
    private final String name;
    private final String purpose;

    public MedicalRecommendation(String name, String purpose) {
        this.name = name;
        this.purpose = purpose;
    }

    public String getName() {
        return name;
    }

    public String getPurpose() {
        return purpose;
    }

    public abstract void printSummary();
}
