package com.healthtriage.repository;

import com.healthtriage.model.Condition;
import java.util.List;
import java.util.Set;

public interface MedicalKnowledgeBase {
    List<Condition> getAllConditions();
    Set<String> getAllKnownSymptoms();
}
