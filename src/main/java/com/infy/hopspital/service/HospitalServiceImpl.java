package com.infy.hopspital.service;

import com.infy.hopspital.dto.DoctorDTO;
import com.infy.hopspital.entity.Doctor;
import com.infy.hopspital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("hospitalService")
@Transactional
public class HospitalServiceImpl implements HospitalService
{
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public DoctorDTO addDoctor(DoctorDTO doctor)
    {
        Doctor added = doctorRepository.save(DoctorDTO.toEntity(doctor));
        doctor.setId(added.getId());
        return doctor;
    }

    @Override
    public List<DoctorDTO> getAllDoctors()
    {
        List<DoctorDTO> ret = new ArrayList<>();
        doctorRepository.findAll().forEach(doctor -> ret.add(DoctorDTO.toDTO(doctor)));
        return ret;
    }
}
