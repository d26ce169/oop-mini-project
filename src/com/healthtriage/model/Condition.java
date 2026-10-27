package com.healthtriage.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Condition {
    private final String id;
    private final String name;
    private final Set<String> symptoms;
    private final DoctorSpecialty recommendedSpecialty;
    private final UrgencyLevel urgency;
    private final List<Medicine> temporaryMedicines;
    private final List<DiagnosticTest> suggestedReports;

    public Condition(String id, String name, Set<String> symptoms, 
                     DoctorSpecialty recommendedSpecialty, UrgencyLevel urgency,
                     List<Medicine> temporaryMedicines, List<DiagnosticTest> suggestedReports) {
        this.id = id;
        this.name = name;
        this.symptoms = symptoms.stream().map(String::toLowerCase).collect(Collectors.toSet());
        this.recommendedSpecialty = recommendedSpecialty;
        this.urgency = urgency;
        this.temporaryMedicines = new ArrayList<>(temporaryMedicines);
        this.suggestedReports = new ArrayList<>(suggestedReports);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getSymptoms() {
        return Collections.unmodifiableSet(symptoms);
    }

    public DoctorSpecialty getRecommendedSpecialty() {
        return recommendedSpecialty;
    }

    public UrgencyLevel getUrgency() {
        return urgency;
    }

    public List<Medicine> getTemporaryMedicines() {
        return Collections.unmodifiableList(temporaryMedicines);
    }

    public List<DiagnosticTest> getSuggestedReports() {
        return Collections.unmodifiableList(suggestedReports);
    }
}
