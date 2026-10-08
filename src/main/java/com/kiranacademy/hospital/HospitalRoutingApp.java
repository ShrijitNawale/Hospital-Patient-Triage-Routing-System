package com.kiranacademy.hospital;

import java.sql.Connection;

public class HospitalRoutingApp {

    public static void main(String[] args) {  

        // Step 1: Get database connection
        Connection connection = DBConnection.getConnection();

        if (connection == null) {
            System.out.println("Database connection failed.");
            return;
        }

        // Step 2: Create DAO object
        PatientDAO patientDAO = new patientDaoimpl();

        // Step 3: Create routing service
        PatientRoutingService patientRoutingService =
                new PatientRoutingService(patientDAO);

        // Step 4: Process patient records
        patientRoutingService.segregatePatientRecord(connection);

        // Step 5: Close connection
        try {
            connection.close();
            System.out.println("Database connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}