# Health Triage & Doctor Recommendation System

An Object-Oriented Java application that analyzes user-reported symptoms, predicts matching health conditions, and provides targeted clinical recommendations.

---

## Features

- **Symptom Matching & Scoring**: Evaluates input symptoms against a medical knowledge base using an extensible diagnosis strategy.
- **Doctor Specialization Referral**: Automatically determines the relevant clinical department and doctor type (e.g., General Physician, Pulmonologist, Cardiologist, Dermatologist, Gastroenterologist).
- **Diagnostic Health Reports**: Suggests laboratory and imaging investigations relevant to the suspected condition.
- **Temporary / OTC Relief**: Lists temporary medication and home-care guidance with precautionary notes.
- **Urgency Classification**: Categorizes cases as `ROUTINE`, `URGENT`, or `EMERGENCY`.

---

## OOP Principles Demonstrated

- **Abstraction**:
  - `DiagnosisStrategy` interface defines the symptom evaluation contract.
  - `MedicalKnowledgeBase` interface defines the clinical data layer contract.
  - `MedicalRecommendation` serves as the abstract base class for clinical actions.
- **Encapsulation**:
  - Private fields, immutable domain collections, and defensive copying in `Condition` and `Patient` models.
- **Inheritance**:
  - `Medicine` and `DiagnosticTest` inherit from `MedicalRecommendation`.
- **Polymorphism**:
  - Dynamic dispatch via `MedicalRecommendation.printSummary()`.
  - Pluggable scoring algorithm via `DiagnosisStrategy`.
- **Composition**:
  - `Condition` composes lists of `Medicine` and `DiagnosticTest` objects.
  - `HealthAssessmentReport` composes prediction results, doctor referrals, and medication details.
- **Repository Pattern**:
  - `InMemoryMedicalDatabase` abstracts data access from business logic.

---

## Project Structure

```
├── .gitignore
├── README.md
└── src/
    └── com/
        └── healthtriage/
            ├── Main.java
            ├── model/
            │   ├── Condition.java
            │   ├── DiagnosticTest.java
            │   ├── DoctorSpecialty.java
            │   ├── MedicalRecommendation.java
            │   ├── Medicine.java
            │   ├── PredictionResult.java
            │   └── UrgencyLevel.java
            ├── repository/
            │   ├── InMemoryMedicalDatabase.java
            │   └── MedicalKnowledgeBase.java
            └── service/
                ├── DiagnosisStrategy.java
                ├── HealthAssessmentReport.java
                └── SymptomOverlapStrategy.java
```

---

## How to Compile & Run

### Using Command Line (Terminal / PowerShell)

1. Open a terminal in the project root directory:
   ```bash
   cd "c:\D26CE169_mini project oop"
   ```

2. Compile all source files into a `bin` directory:
   ```bash
   javac -d bin src/com/healthtriage/**/*.java src/com/healthtriage/*.java
   ```

3. Run the application:
   ```bash
   java -cp bin com.healthtriage.Main
   ```

### Using an IDE (IntelliJ IDEA / Eclipse / VS Code)

1. Open the project folder (`D26CE169_mini project oop`) in your IDE.
2. Ensure the `src` folder is marked as the **Sources Root**.
3. Open `src/com/healthtriage/Main.java` and click **Run**.

---

## How to Push to Git

```bash
git init
git add .
git commit -m "Initial commit: Health Triage & Doctor Recommendation System (OOP)"
git branch -M main
git remote add origin <YOUR_GITHUB_REPO_URL>
git push -u origin main
```
