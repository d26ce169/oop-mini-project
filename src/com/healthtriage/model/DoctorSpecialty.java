package com.healthtriage.model;

public enum DoctorSpecialty {
    GENERAL_PHYSICIAN("General Physician", "Primary Care Clinic"),
    CARDIOLOGIST("Cardiologist", "Department of Cardiology"),
    PULMONOLOGIST("Pulmonologist", "Respiratory & Chest Clinic"),
    DERMATOLOGIST("Dermatologist", "Skin & Allergy Care"),
    GASTROENTEROLOGIST("Gastroenterologist", "Digestive Health Clinic"),
    NEUROLOGIST("Neurologist", "Neurological Institute");

    private final String title;
    private final String department;

    DoctorSpecialty(String title, String department) {
        this.title = title;
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }
}
