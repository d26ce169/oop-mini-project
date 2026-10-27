package com.healthtriage;

import com.healthtriage.model.PredictionResult;
import com.healthtriage.repository.InMemoryMedicalDatabase;
import com.healthtriage.repository.MedicalKnowledgeBase;
import com.healthtriage.service.DiagnosisStrategy;
import com.healthtriage.service.HealthAssessmentReport;
import com.healthtriage.service.SymptomOverlapStrategy;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MedicalKnowledgeBase database = new InMemoryMedicalDatabase();
        DiagnosisStrategy strategy = new SymptomOverlapStrategy();

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================================");
        System.out.println("     HEALTH TRIAGE & DOCTOR RECOMMENDATION SYSTEM (JAVA)   ");
        System.out.println("==========================================================");
        System.out.println("Available symptoms in database:");
        System.out.println(String.join(", ", database.getAllKnownSymptoms()));
        System.out.println("----------------------------------------------------------");
        System.out.println("Enter symptoms separated by commas (or press ENTER for default demo):");
        System.out.print("> ");
        String userInput = scanner.nextLine().trim();

        List<String> symptomsToAnalyze;
        if (userInput.isEmpty()) {
            System.out.println("\n[Demo Mode]: Analyzing default symptoms: 'fever, cough, sore throat'");
            symptomsToAnalyze = List.of("fever", "cough", "sore throat");
        } else {
            symptomsToAnalyze = Arrays.stream(userInput.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
        }

        List<PredictionResult> predictions = strategy.evaluate(symptomsToAnalyze, database.getAllConditions());
        HealthAssessmentReport report = new HealthAssessmentReport(symptomsToAnalyze, predictions);
        report.display();

        scanner.close();
    }
}
