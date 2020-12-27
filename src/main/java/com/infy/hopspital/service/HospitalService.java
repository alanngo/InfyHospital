package com.infy.hopspital.service;

import com.infy.hopspital.dto.DoctorDTO;
import com.infy.hopspital.dto.PatientDTO;

import java.util.List;

public interface HospitalService
{
    DoctorDTO addDoctor(DoctorDTO doctor);

    List<DoctorDTO> getAllDoctors();

    PatientDTO addPatient(PatientDTO patientDTO);

    DoctorDTO allocatePatient(String patientId, String doctorId);

}
