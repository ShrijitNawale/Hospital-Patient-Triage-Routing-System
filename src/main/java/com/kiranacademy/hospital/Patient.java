package com.kiranacademy.hospital;
import java.util.Scanner;
import java.sql.Date;
import java.sql.Timestamp;

public class Patient {
	private int patientId;
	private String patientName;
	private int age;
	private String gender;
	private String disease;
	private String admissionType;
	private String conditionStatus;
	private int triageScore;
	private String doctorName;
	private String mobile;
	public Patient() {
	}
	public Patient(int patientId, String patientName, int age, String gender, String disease, String admissionType,
			String conditionStatus, int triageScore, String doctorName, String mobile) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.gender = gender;
		this.disease = disease;
		this.admissionType = admissionType;
		this.conditionStatus = conditionStatus;
		this.triageScore = triageScore;
		this.doctorName = doctorName;
		this.mobile = mobile;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getAdmissionType() {
		return admissionType;
	}
	public void setAdmissionType(String admissionType) {
		this.admissionType = admissionType;
	}
	public String getConditionStatus() {
		return conditionStatus;
	}
	public void setConditionStatus(String conditionStatus) {
		this.conditionStatus = conditionStatus;
	}
	public int getTriageScore() {
		return triageScore;
	}
	public void setTriageScore(int triageScore) {
		this.triageScore = triageScore;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", age=" + age + ", gender="
				+ gender + ", disease=" + disease + ", admissionType=" + admissionType + ", conditionStatus="
				+ conditionStatus + ", triageScore=" + triageScore + ", doctorName=" + doctorName + ", mobile=" + mobile
				+ "]";
	}
	

	public void acceptPatientDetails() {

	    Scanner sc = new Scanner(System.in);

	    System.out.print("Enter Patient ID: ");
	    patientId = sc.nextInt();
	    sc.nextLine();

	    System.out.print("Enter Patient Name: ");
	    patientName = sc.nextLine();

	    System.out.print("Enter Age: ");
	    age = sc.nextInt();
	    sc.nextLine();

	    System.out.print("Enter Gender: ");
	    gender = sc.nextLine();

	    System.out.print("Enter Disease: ");
	    disease = sc.nextLine();

	    System.out.print("Enter Admission Type: ");
	    admissionType = sc.nextLine();

	    System.out.print("Enter Condition Status: ");
	    conditionStatus = sc.nextLine();

	    System.out.print("Enter Triage Score: ");
	    triageScore = sc.nextInt();
	    sc.nextLine();

	    System.out.print("Enter Doctor Name: ");
	    doctorName = sc.nextLine();

	    System.out.print("Enter Mobile Number: ");
	    mobile = sc.nextLine();
	}
}
