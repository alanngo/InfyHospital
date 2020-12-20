package com.infy.hopspital.service;

import com.infy.hopspital.dto.DoctorDTO;

import java.util.List;

public interface HospitalService
{
    DoctorDTO addDoctor(DoctorDTO doctor);

    List<DoctorDTO> getAllDoctors();

}
