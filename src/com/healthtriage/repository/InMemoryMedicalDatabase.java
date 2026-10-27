package com.healthtriage.repository;

import com.healthtriage.model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class InMemoryMedicalDatabase implements MedicalKnowledgeBase {
    private final List<Condition> conditions = new ArrayList<>();

    public InMemoryMedicalDatabase() {
        seedKnowledgeBase();
    }

    private void seedKnowledgeBase() {
        conditions.add(new Condition(
            "C01", "Viral Upper Respiratory Infection (Common Cold / Flu)",
            Set.of("fever", "cough", "sore throat", "runny nose", "fatigue"),
            DoctorSpecialty.GENERAL_PHYSICIAN,
            UrgencyLevel.ROUTINE,
            List.of(
                new Medicine("Paracetamol", "Fever and headache reduction", "500mg every 6 hours as needed", true),
                new Medicine("Cetirizine", "Alleviates runny nose and sneezing", "10mg once daily at bedtime", true),
                new Medicine("Saline Nasal Spray", "Nasal decongestion", "2-3 sprays per nostril as needed", true)
            ),
            List.of(
                new DiagnosticTest("Complete Blood Count (CBC)", "Checks for elevated white blood cells / infection", "Blood"),
                new DiagnosticTest("Rapid Influenza Nasal Swab", "Identifies Influenza A/B strains", "Nasal Swab")
            )
        ));

        conditions.add(new Condition(
            "C02", "Bronchial Spasm / Acute Bronchitis",
            Set.of("wheezing", "shortness of breath", "persistent cough", "chest tightness"),
            DoctorSpecialty.PULMONOLOGIST,
            UrgencyLevel.URGENT,
            List.of(
                new Medicine("Salbutamol Inhaler", "Relieves acute airway constriction", "1-2 puffs via spacer as prescribed", false),
                new Medicine("Guaifenesin", "Expectorant to loosen mucus", "200-400mg every 4 hours with water", true)
            ),
            List.of(
                new DiagnosticTest("Chest X-Ray (PA View)", "Rules out pneumonia or lung infiltration", "Imaging"),
                new DiagnosticTest("Spirometry (PFT)", "Measures airflow limitation and lung volume", "Breath Analysis")
            )
        ));

        conditions.add(new Condition(
            "C03", "Suspected Coronary Event / Angina Pectoris",
            Set.of("chest pain", "shortness of breath", "dizziness", "left arm pain", "cold sweat"),
            DoctorSpecialty.CARDIOLOGIST,
            UrgencyLevel.EMERGENCY,
            List.of(
                new Medicine("Aspirin (Dispersible)", "Immediate anti-platelet emergency measure", "300mg chewed immediately", true),
                new Medicine("Sorbitrate (Sublingual)", "Dilates coronary vessels", "Use only under direct medical advice", false)
            ),
            List.of(
                new DiagnosticTest("12-Lead Electrocardiogram (ECG)", "Detects myocardial ischemia or arrhythmia", "Electrical Trace"),
                new DiagnosticTest("Serum Troponin-I / T", "Cardiac biomarkers confirming heart muscle injury", "Blood")
            )
        ));

        conditions.add(new Condition(
            "C04", "Allergic Contact Dermatitis / Skin Eczema",
            Set.of("itching", "red rash", "dry skin", "skin inflammation", "burning skin"),
            DoctorSpecialty.DERMATOLOGIST,
            UrgencyLevel.ROUTINE,
            List.of(
                new Medicine("Hydrocortisone Cream 1%", "Reduces localized itching and swelling", "Apply thin layer twice daily", true),
                new Medicine("Calamine Lotion", "Soothes irritated skin and blisters", "Apply generously as needed", true)
            ),
            List.of(
                new DiagnosticTest("Skin Patch Test", "Identifies specific contact allergens", "Skin Contact"),
                new DiagnosticTest("Serum IgE Level", "Measures allergic response marker", "Blood")
            )
        ));

        conditions.add(new Condition(
            "C05", "Gastroesophageal Reflux Disease (GERD) / Acid Peptic Disorder",
            Set.of("heartburn", "acid reflux", "stomach pain", "nausea", "bloating"),
            DoctorSpecialty.GASTROENTEROLOGIST,
            UrgencyLevel.ROUTINE,
            List.of(
                new Medicine("Antacid Gel (Aluminium/Magnesium Hydroxide)", "Neutralizes stomach acid immediately", "10-20ml after meals", true),
                new Medicine("Pantoprazole", "Proton-pump inhibitor to lower acid secretion", "40mg 30 minutes before breakfast", true)
            ),
            List.of(
                new DiagnosticTest("Upper GI Endoscopy", "Visualizes esophageal/gastric lining", "Endoscopic Imaging"),
                new DiagnosticTest("H. pylori Stool Antigen Test", "Screens for Helicobacter pylori infection", "Stool")
            )
        ));
    }

    @Override
    public List<Condition> getAllConditions() {
        return Collections.unmodifiableList(conditions);
    }

    @Override
    public Set<String> getAllKnownSymptoms() {
        Set<String> all = new TreeSet<>();
        for (Condition c : conditions) {
            all.addAll(c.getSymptoms());
        }
        return Collections.unmodifiableSet(all);
    }
}
