package com.kiranacademy.hospital;

import java.util.ArrayList;
import java.util.List;

public class PatientValidator {

    public List<String> validatePatient(Patient patient) {

        List<String> errors = new ArrayList<>();

        // Patient Name
        if (patient.getPatientName() == null
                || patient.getPatientName().trim().isEmpty()) {

            errors.add("Patient name is required.");

        } else if (patient.getPatientName().trim().length() < 3) {

            errors.add("Patient name must contain at least 3 characters.");
        }

        // Age
        if (patient.getAge() < 0 || patient.getAge() > 120) {
            errors.add("Age must be between 0 and 120.");
        }

        // Gender
        if (patient.getGender() == null
                || !(patient.getGender().equals("Male")
                || patient.getGender().equals("Female")
                || patient.getGender().equals("Other"))) {

            errors.add("Gender must be Male, Female, or Other.");
        }

        // Disease
        if (patient.getDisease() == null
                || patient.getDisease().trim().isEmpty()) {

            errors.add("Disease is required.");
        }

        // Admission Type
        if (patient.getAdmissionType() == null
                || !(patient.getAdmissionType().equals("Emergency")
                || patient.getAdmissionType().equals("Regular"))) {

            errors.add("Admission type must be Emergency or Regular.");
        }

        // Condition Status
        if (patient.getConditionStatus() == null
                || !(patient.getConditionStatus().equals("Critical")
                || patient.getConditionStatus().equals("Moderate")
                || patient.getConditionStatus().equals("Stable"))) {

            errors.add("Condition status must be Critical, Moderate, or Stable.");
        }

        // Triage Score
        if (patient.getTriageScore() < 1
                || patient.getTriageScore() > 10) {

            errors.add("Triage score must be between 1 and 10.");
        }

        // Doctor Name
        if (patient.getDoctorName() == null
                || patient.getDoctorName().trim().isEmpty()) {

            errors.add("Doctor name is required.");
        }

        
       

        // Mobile
        if (patient.getMobile() == null
                || !patient.getMobile().matches("\\d{10}")) {

            errors.add("Mobile number must contain exactly 10 digits.");
        }

        // Transfer Status
       

        return errors;
    }
}