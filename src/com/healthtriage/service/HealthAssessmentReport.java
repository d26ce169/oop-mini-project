package com.healthtriage.service;

import com.healthtriage.model.Condition;
import com.healthtriage.model.DiagnosticTest;
import com.healthtriage.model.DoctorSpecialty;
import com.healthtriage.model.Medicine;
import com.healthtriage.model.PredictionResult;
import com.healthtriage.model.UrgencyLevel;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HealthAssessmentReport {
    private final List<String> inputSymptoms;
    private final PredictionResult topPrediction;
    private final List<PredictionResult> alternatePossibilities;

    public HealthAssessmentReport(List<String> inputSymptoms, List<PredictionResult> rankedPredictions) {
        this.inputSymptoms = inputSymptoms;
        if (!rankedPredictions.isEmpty()) {
            this.topPrediction = rankedPredictions.get(0);
            this.alternatePossibilities = rankedPredictions.stream().skip(1).limit(2).collect(Collectors.toList());
        } else {
            this.topPrediction = null;
            this.alternatePossibilities = Collections.emptyList();
        }
    }

    public void display() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("              CLINICAL TRIAGE & RECOMMENDATION REPORT              ");
        System.out.println("=".repeat(70));

        System.out.println("\n[1] INPUT SYMPTOMS ANALYZED:");
        System.out.println("    " + String.join(", ", inputSymptoms));

        if (topPrediction == null) {
            System.out.println("\n[!] NO DIRECT MATCH FOUND");
            System.out.println("    The symptoms provided do not match known templates.");
            System.out.println("    Recommendation: Please consult a General Physician for evaluation.");
            System.out.println("=".repeat(70));
            return;
        }

        Condition condition = topPrediction.getCondition();

        System.out.println("\n[2] PRIMARY PREDICTED CONDITION:");
        System.out.printf("    ▶ %s%n", condition.getName());
        System.out.printf("    • Match Confidence : %.1f%%%n", topPrediction.getMatchPercentage());
        System.out.printf("    • Matched Symptoms : %s%n", String.join(", ", topPrediction.getMatchedSymptoms()));
        System.out.printf("    • Triage Urgency   : [%s]%n", condition.getUrgency());

        if (condition.getUrgency() == UrgencyLevel.EMERGENCY) {
            System.out.println("    CAUTION: These symptoms suggest an emergency. Seek nearest ER immediately!");
        }

        System.out.println("\n[3] RECOMMENDED DOCTOR REFERRAL:");
        DoctorSpecialty specialty = condition.getRecommendedSpecialty();
        System.out.printf("    • Specialist Type : %s%n", specialty.getTitle());
        System.out.printf("    • Facility / Wing : %s%n", specialty.getDepartment());

        System.out.println("\n[4] SUGGESTED HEALTH REPORTS & DIAGNOSTIC TESTS:");
        for (DiagnosticTest test : condition.getSuggestedReports()) {
            test.printSummary();
        }

        System.out.println("\n[5] TEMPORARY / OTC RELIEF MEASURES:");
        for (Medicine med : condition.getTemporaryMedicines()) {
            med.printSummary();
        }

        if (!alternatePossibilities.isEmpty()) {
            System.out.println("\n[6] OTHER DIFFERENTIAL POSSIBILITIES CONSIDERED:");
            for (PredictionResult alt : alternatePossibilities) {
                System.out.printf("    • %s (Confidence: %.1f%%)%n", 
                        alt.getCondition().getName(), alt.getMatchPercentage());
            }
        }

        System.out.println("\n" + "-".repeat(70));
        System.out.println("DISCLAIMER: This system is an algorithmic tool based on OOP principles.");
        System.out.println("It does not replace professional medical judgment. Always consult a licensed doctor.");
        System.out.println("=".repeat(70));
    }
}
