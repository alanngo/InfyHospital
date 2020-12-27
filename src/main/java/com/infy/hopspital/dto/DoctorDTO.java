package com.infy.hopspital.dto;

import com.infy.hopspital.entity.Doctor;
import com.infy.hopspital.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO
{
    private String id;
    private String name;
    private Integer numYears;
    private List<PatientDTO> patientDTOList;

    public static DoctorDTO toDTO(Doctor doctor)
    {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(doctor.getId());
        doctorDTO.setName(doctor.getName());
        doctorDTO.setNumYears(doctor.getNumYears());
        List<PatientDTO> tmp = new ArrayList<>();
        doctorDTO.setPatientDTOList(new ArrayList<>());
        if (doctor.getPatients() == null)
            doctor.setPatients(new ArrayList<>());
        doctor.getPatients().forEach(patient -> tmp.add(PatientDTO.toDTO(patient)));
        doctorDTO.setPatientDTOList(tmp);
        return doctorDTO;
    }

    public static Doctor toEntity(DoctorDTO doctorDTO)
    {
        Doctor ret = new Doctor();
        List<Patient> patList = new ArrayList<>();
        ret.setName(doctorDTO.getName());
        ret.setNumYears(doctorDTO.getNumYears());
        if (doctorDTO.getPatientDTOList() == null)
            doctorDTO.setPatientDTOList(new ArrayList<>());
        doctorDTO.getPatientDTOList().forEach(p -> patList.add(PatientDTO.toEntity(p)));
        ret.setPatients(patList);
        return ret;
    }

}
