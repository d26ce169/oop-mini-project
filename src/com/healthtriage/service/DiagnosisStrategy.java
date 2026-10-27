package com.healthtriage.service;

import com.healthtriage.model.Condition;
import com.healthtriage.model.PredictionResult;
import java.util.List;

public interface DiagnosisStrategy {
    List<PredictionResult> evaluate(List<String> userSymptoms, List<Condition> knowledgeBase);
}
