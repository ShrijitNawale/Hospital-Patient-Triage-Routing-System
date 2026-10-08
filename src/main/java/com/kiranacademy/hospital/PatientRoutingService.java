package com.kiranacademy.hospital;
import java.sql.Connection;
import java.util.List;
public class PatientRoutingService {

    PatientDAO patientDAO = null;

    PatientValidator patientValidator = new PatientValidator();

    private int totalPendingRecords = 0;
    private int criticalCare = 0;
    private int generalCare = 0;
    private int validationFailed = 0;
    private int skippedDuplicate = 0;
    private int successfullyProcessed = 0;

    public PatientRoutingService(PatientDAO patientDAO) {

        this.patientDAO = patientDAO;

    }

    public void segregatePatientRecord(Connection connection) {

        try {
            List<Patient> allPatients =
                    patientDAO.getPendingPatients(connection);

            totalPendingRecords = allPatients.size();

            for (Patient patient : allPatients) {

                if (patientDAO.alreadyTransferred(
                        patient.getPatientId(), connection)) {

                    skippedDuplicate++;

                    System.out.println(
                            "Patient ID " + patient.getPatientId()
                            + " skipped - duplicate record.");

                    continue;
                }
                List<String> errors =
                        patientValidator.validatePatient(patient);
                
                if (!errors.isEmpty()) {

                    validationFailed++;

                    System.out.println(
                            "Patient ID " + patient.getPatientId()
                            + " validation failed.");

                    for (String error : errors) {

                        System.out.println(" - " + error);
                    }

                    continue;
                }
                System.out.println(
                        "Patient ID " + patient.getPatientId()
                        + " validation successful.");
                if (isCritical(patient)) {

                    patientDAO.insertCriticalPatient(
                            patient, connection);

                    criticalCare++;

                    patientDAO.markProcessed(
                            patient.getPatientId(), connection);

                    successfullyProcessed++;

                    System.out.println(
                            "Patient routed to Critical Care.");
                } else {

                    patientDAO.insertGeneralPatient(
                            patient, connection);

                    generalCare++;

                    patientDAO.markProcessed(
                            patient.getPatientId(), connection);

                    successfullyProcessed++;

                    System.out.println(
                            "Patient routed to General Care.");
                }
            }
            displaySummary();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean isCritical(Patient patient) {
        if (patient.getConditionStatus().equals("Critical")) {
            return true;
        }
        if (patient.getAdmissionType().equals("Emergency")
                && patient.getTriageScore() >= 7) {
            return true;
        }
        if (patient.getConditionStatus().equals("Moderate")
                && patient.getTriageScore() >= 8) {
           return true;
        }
        return false;
    }
    public void displaySummary() {
    	System.out.println();
        System.out.println("======================================");
        System.out.println("        PROCESSING SUMMARY");
        System.out.println("======================================");

        System.out.println(
                "Total Pending Records : " + totalPendingRecords);

        System.out.println(
                "Critical Care        : " + criticalCare);

        System.out.println(
                "General Care         : " + generalCare);

        System.out.println(
                "Validation Failed    : " + validationFailed);

        System.out.println(
                "Skipped Duplicate    : " + skippedDuplicate);

        System.out.println(
                "Successfully Processed : "
                + successfullyProcessed);
        System.out.println("======================================");
    }
}