i# Healthcare Master Patient Index (MPI) – Data Model & Matching Design

This repository contains a simplified **Master Patient Index (MPI)** design for a healthcare platform.  
The goal is to determine whether an incoming patient record belongs to an existing patient or represents a new one, while supporting multiple hospitals, medical records, and insurance information.

The solution emphasizes **clarity, determinism, and production-readiness**, rather than over-engineering.

---

## 📌 Scope

This implementation covers:

- Multi-hospital and multi-branch support
- Master Patient (golden record) management
- Hospital-specific Medical Record Numbers (MRN)
- Outpatient and inpatient visits
- Insurance association per medical record
- Reusable address management
- Deterministic patient matching logic

---

## 🧠 Design Principles

- **Single source of truth**: One `MasterPatient` represents one real person
- **Hospital-scoped MRN**: Medical Record Numbers are unique per hospital, not globally
- **Explainable matching**: Rule-based matching, easy to audit and debug
- **Minimal but extensible**: Avoids unnecessary complexity while remaining scalable

---

## 🗂️ Data Model Overview

### Core Entities

#### 1. Hospital
Represents a hospital and its branches.

**Attributes:**
- `hospital_id` (PK)
- `hospital_name`
- `branch_name`
- `capacity`
- `created_at`

---

#### 2. MasterPatient
Represents the **golden patient record** (one real person).

**Attributes:**
- `patient_id` (PK)
- `full_name`
- `gender`
- `date_of_birth`
- `national_id`
- `phone`
- `email`
- `is_merged` (flag indicating the patient has been merged into another record)
- `created_at`

---

#### 3. MedicalRecord
Represents a single patient encounter or visit.

**Attributes:**
- `medical_record_id` (PK)
- `patient_id` (FK → MasterPatient)
- `hospital_id` (FK → Hospital)
- `medical_record_no` (MRN, hospital-specific)
- `visit_type` (OUTPATIENT / INPATIENT)
- `insurance_provider`
- `admission_date`
- `discharge_date`

**Constraints:**
- `UNIQUE(hospital_id, medical_record_no)`

---

#### 4. Address
Reusable address entity for both patients and hospitals.

**Attributes:**
- `address_id` (PK)
- `address_type` (HOME / OFFICE)
- `street`
- `city`
- `province`
- `postal_code`
- `country`

---

### Relationship Tables

- `PatientAddress` – links `MasterPatient` to `Address`
- `HospitalAddress` – links `Hospital` to `Address`

---

## 📐 Entity Relationship Diagram (ERD)

```mermaid
erDiagram

HOSPITAL {
  UUID hospital_id PK
  string hospital_name
  string branch_name
  int capacity
  datetime created_at
}

MASTER_PATIENT {
  UUID patient_id PK
  string full_name
  string gender
  date date_of_birth
  string national_id
  string phone
  string email
  boolean is_merged
  datetime created_at
}

MEDICAL_RECORD {
  UUID medical_record_id PK
  UUID patient_id FK
  UUID hospital_id FK
  string medical_record_no
  string visit_type
  string insurance_provider
  date admission_date
  date discharge_date
}

ADDRESS {
  UUID address_id PK
  string address_type
  string street
  string city
  string province
  string postal_code
  string country
}

PATIENT_ADDRESS {
  UUID patient_id FK
  UUID address_id FK
}

HOSPITAL_ADDRESS {
  UUID hospital_id FK
  UUID address_id FK
}

HOSPITAL ||--o{ MEDICAL_RECORD : provides
MASTER_PATIENT ||--o{ MEDICAL_RECORD : has
MASTER_PATIENT ||--o{ PATIENT_ADDRESS : owns
ADDRESS ||--o{ PATIENT_ADDRESS : linked_to
HOSPITAL ||--o{ HOSPITAL_ADDRESS : located_at
ADDRESS ||--o{ HOSPITAL_ADDRESS : linked_to

