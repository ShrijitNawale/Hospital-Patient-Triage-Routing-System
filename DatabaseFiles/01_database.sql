CREATE TABLE hospital_patient_intake (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10),
    disease VARCHAR(120) NOT NULL,
    admission_type VARCHAR(20),
    condition_status VARCHAR(20),
    triage_score INT,
    doctor_name VARCHAR(100) NOT NULL,
    admission_date DATE,
    mobile VARCHAR(15),
    transfer_status VARCHAR(20) DEFAULT 'PENDING',
    processed_at DATETIME NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    CHECK (CHAR_LENGTH(patient_name) >= 3),
    CHECK (gender IN ('Male', 'Female', 'Other')),
    CHECK (admission_type IN ('Emergency', 'Regular')),
    CHECK (condition_status IN ('Critical', 'Moderate', 'Stable'))
);
CREATE TABLE critical_care_patients (
    critical_id INT PRIMARY KEY AUTO_INCREMENT,
    source_patient_id INT UNIQUE,
    patient_name VARCHAR(100),
    age INT,
    disease VARCHAR(120),
    admission_type VARCHAR(20),
    condition_status VARCHAR(20),
    triage_score INT,
    doctor_name VARCHAR(100),
    routed_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (source_patient_id)
        REFERENCES hospital_patient_intake(patient_id)
);
CREATE TABLE general_care_patients (
    general_id INT PRIMARY KEY AUTO_INCREMENT,
    source_patient_id INT UNIQUE,
    patient_name VARCHAR(100),
    age INT,
    disease VARCHAR(120),
    admission_type VARCHAR(20),
    condition_status VARCHAR(20),
    triage_score INT,
    doctor_name VARCHAR(100),
    routed_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (source_patient_id)
        REFERENCES hospital_patient_intake(patient_id)
);