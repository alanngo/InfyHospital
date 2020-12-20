package com.infy.hopspital.dto;

import com.infy.hopspital.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoctorDTO
{
    private String id;
    private String name;
    private Integer numYears;

    public static DoctorDTO toDTO(Doctor doctor)
    {
        return new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getNumYears());
    }

    public static Doctor toEntity(DoctorDTO doctorDTO)
    {
        Doctor ret = new Doctor();
        ret.setName(doctorDTO.getName());
        ret.setNumYears(doctorDTO.getNumYears());
        return ret;
    }

}
