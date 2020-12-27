package com.infy.hopspital.service;

import com.infy.hopspital.dto.DoctorDTO;
import com.infy.hopspital.dto.PatientDTO;
import com.infy.hopspital.entity.Doctor;
import com.infy.hopspital.entity.Patient;
import com.infy.hopspital.repository.DoctorRepository;
import com.infy.hopspital.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("hospitalService")
@Slf4j // gives us a logger
public class HospitalServiceImpl implements HospitalService
{
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

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
        log.info(doctorRepository.findAll().toString());
        doctorRepository.findAll().forEach(d ->
        {
            DoctorDTO tmp = DoctorDTO.toDTO(d);
            ret.add(tmp);
        });
        log.info(doctorRepository.findById("5fdfb54aec1f8c7069de30f4").toString());
        return ret;
    }

    @Override
    public PatientDTO addPatient(PatientDTO patientDTO)
    {
        Patient p = patientRepository.save(PatientDTO.toEntity(patientDTO));
        patientDTO.setId(p.getId());
        return patientDTO;
    }

    @Override
    public DoctorDTO allocatePatient(String patientId, String doctorId)
    {
        Patient p = patientRepository.findById(patientId) //performed a null check
                .orElseThrow(() -> new RuntimeException("patient not found"));
        Doctor d = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("patient not found"));
        if (d.getPatients()==null)
            d.setPatients(new ArrayList<>());
        List<Patient> patients = d.getPatients();
        patients.add(p);
        doctorRepository.save(d); // you actually need this line of code, bc @Transactional doesn't work w/ MongoDB
        return DoctorDTO.toDTO(d);
    }
}
