package com.infy.hopspital.dto;

import com.infy.hopspital.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO
{
    private String id;

    @EqualsAndHashCode.Exclude
    private String name;

    @EqualsAndHashCode.Exclude
    private String reason;

    public static PatientDTO toDTO(Patient patient)
    {
        return new PatientDTO(patient.getId(), patient.getName(), patient.getReason());
    }

    public static Patient toEntity(PatientDTO patientDTO)
    {
        Patient ret = new Patient();
        ret.setName(patientDTO.getName());
        ret.setReason(patientDTO.getReason());
        return ret;
    }


}
