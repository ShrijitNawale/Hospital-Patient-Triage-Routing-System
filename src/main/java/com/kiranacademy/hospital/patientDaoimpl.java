package com.kiranacademy.hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class patientDaoimpl implements PatientDAO{

    public List<Patient> getAllPatients(Connection connection) {

        List<Patient> patients = new ArrayList<>();

        String sql = "SELECT * FROM hospital_patient_intake ";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

           

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Patient patient = new Patient();

                patient.setPatientId(rs.getInt("patient_id"));
                patient.setPatientName(rs.getString("patient_name"));
                patient.setAge(rs.getInt("age"));
                patient.setGender(rs.getString("gender"));
                patient.setDisease(rs.getString("disease"));
                patient.setAdmissionType(rs.getString("admission_type"));
                patient.setConditionStatus(rs.getString("condition_status"));
                patient.setTriageScore(rs.getInt("triage_score"));
                patient.setDoctorName(rs.getString("doctor_name"));
                patient.setMobile(rs.getString("mobile"));

                patients.add(patient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;

    }

	@Override
	public void insertCriticalPatient(Patient patient, Connection connection) {

	    String sql = "INSERT INTO critical_care_patients "
	               + "(source_patient_id, patient_name, age, disease, "
	               + "admission_type, condition_status, triage_score, doctor_name) "
	               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setInt(1, patient.getPatientId());
	        ps.setString(2, patient.getPatientName());
	        ps.setInt(3, patient.getAge());
	        ps.setString(4, patient.getDisease());
	        ps.setString(5, patient.getAdmissionType());
	        ps.setString(6, patient.getConditionStatus());
	        ps.setInt(7, patient.getTriageScore());
	        ps.setString(8, patient.getDoctorName());

	        ps.executeUpdate();

	        System.out.println("Patient inserted into Critical Care.");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void insertGeneralPatient(Patient patient, Connection connection) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO general_care_patients "
	               + "(source_patient_id, patient_name, age, disease, "
	               + "admission_type, condition_status, triage_score, doctor_name) "
	               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setInt(1, patient.getPatientId());
	        ps.setString(2, patient.getPatientName());
	        ps.setInt(3, patient.getAge());
	        ps.setString(4, patient.getDisease());
	        ps.setString(5, patient.getAdmissionType());
	        ps.setString(6, patient.getConditionStatus());
	        ps.setInt(7, patient.getTriageScore());
	        ps.setString(8, patient.getDoctorName());

	        ps.executeUpdate();

	        System.out.println("Patient inserted into Critical Care.");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void markProcessed(int patientId, Connection connection) {

	    String sql = "UPDATE hospital_patient_intake "
	               + "SET transfer_status = ?, processed_at = CURRENT_TIMESTAMP "
	               + "WHERE patient_id = ?";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, "PROCESSED");
	        ps.setInt(2, patientId);

	        ps.executeUpdate();

	        System.out.println("Patient marked as PROCESSED.");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public boolean alreadyTransferred(int patientId, Connection connection) {

	    String sql = "SELECT COUNT(*) FROM critical_care_patients "
	               + "WHERE source_patient_id = ? "
	               + "UNION ALL "
	               + "SELECT COUNT(*) FROM general_care_patients "
	               + "WHERE source_patient_id = ?";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setInt(1, patientId);
	        ps.setInt(2, patientId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            if (rs.getInt(1) > 0) {
	                return true;
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}

	@Override
	public List<Patient> getPendingPatients(Connection connection) {

	    List<Patient> patients = new ArrayList<>();

	    String sql = "SELECT * FROM hospital_patient_intake "
	               + "WHERE transfer_status = ?";

	    try (PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, "PENDING");

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            Patient patient = new Patient();

	            patient.setPatientId(
	                    rs.getInt("patient_id"));

	            patient.setPatientName(
	                    rs.getString("patient_name"));

	            patient.setAge(
	                    rs.getInt("age"));

	            patient.setGender(
	                    rs.getString("gender"));

	            patient.setDisease(
	                    rs.getString("disease"));

	            patient.setAdmissionType(
	                    rs.getString("admission_type"));

	            patient.setConditionStatus(
	                    rs.getString("condition_status"));

	            patient.setTriageScore(
	                    rs.getInt("triage_score"));

	            patient.setDoctorName(
	                    rs.getString("doctor_name"));

	            
	            patient.setMobile(
	                    rs.getString("mobile"));

	            patients.add(patient);
	        }

	    } catch (SQLException e) {

	        e.printStackTrace();
	    }

	    return patients;
	}
}
