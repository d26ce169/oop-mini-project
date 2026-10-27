package com.healthtriage.service;

import com.healthtriage.model.Condition;
import com.healthtriage.model.PredictionResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SymptomOverlapStrategy implements DiagnosisStrategy {
    @Override
    public List<PredictionResult> evaluate(List<String> rawUserSymptoms, List<Condition> conditions) {
        Set<String> normalizedInputs = rawUserSymptoms.stream()
                .map(String::trim)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        List<PredictionResult> results = new ArrayList<>();

        for (Condition condition : conditions) {
            Set<String> diseaseSymptoms = condition.getSymptoms();
            List<String> matched = new ArrayList<>();

            for (String userSymptom : normalizedInputs) {
                if (diseaseSymptoms.contains(userSymptom)) {
                    matched.add(userSymptom);
                }
            }

            if (!matched.isEmpty()) {
                double score = ((double) matched.size() / diseaseSymptoms.size()) * 100.0;
                results.add(new PredictionResult(condition, score, matched));
            }
        }

        results.sort((a, b) -> Double.compare(b.getMatchPercentage(), a.getMatchPercentage()));
        return results;
    }
}
