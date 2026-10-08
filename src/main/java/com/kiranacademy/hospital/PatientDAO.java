package com.kiranacademy.hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface PatientDAO {

    public List<Patient> getAllPatients(Connection connection);
    public void insertCriticalPatient(Patient patient, Connection connection);
    public void insertGeneralPatient(Patient patient, Connection connection);
    public void markProcessed(int patientId, Connection connection);
	public boolean alreadyTransferred(int patientId, Connection connection);
	public List<Patient> getPendingPatients(Connection connection);
    

}