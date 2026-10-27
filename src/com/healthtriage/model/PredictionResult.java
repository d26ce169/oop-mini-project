package com.healthtriage.model;

import java.util.Collections;
import java.util.List;

public class PredictionResult {
    private final Condition condition;
    private final double matchPercentage;
    private final List<String> matchedSymptoms;

    public PredictionResult(Condition condition, double matchPercentage, List<String> matchedSymptoms) {
        this.condition = condition;
        this.matchPercentage = matchPercentage;
        this.matchedSymptoms = matchedSymptoms;
    }

    public Condition getCondition() {
        return condition;
    }

    public double getMatchPercentage() {
        return matchPercentage;
    }

    public List<String> getMatchedSymptoms() {
        return Collections.unmodifiableList(matchedSymptoms);
    }
}
