package com.infy.hopspital.api;

import com.infy.hopspital.dto.DoctorDTO;
import com.infy.hopspital.dto.PatientDTO;
import com.infy.hopspital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Repository, Service, API/controller
@RestController
@CrossOrigin
@RequestMapping("/hospital")
public class HospitalAPI
{
    @Autowired
    HospitalService hospitalService;

    @GetMapping("")
    public ResponseEntity<String> welcome()
    {
        return new ResponseEntity<>( "Welcome to Hogwarts", ACCEPTED);
    }

    @PostMapping("/doctors")
    public ResponseEntity<DoctorDTO> addDoctor(@RequestBody DoctorDTO doctorDTO)
    {
        hospitalService.addDoctor(doctorDTO);
        return new ResponseEntity<>(doctorDTO, CREATED);
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDTO>> getDoctors()
    {
        List<DoctorDTO> doctors = hospitalService.getAllDoctors();
        return new ResponseEntity<>(doctors, OK);
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientDTO> addPatient(@RequestBody PatientDTO patientDTO)
    {
        hospitalService.addPatient(patientDTO);
        return new ResponseEntity<>(patientDTO, CREATED);
    }

    @PutMapping("/doctors/{patientId}/{doctorId}")
    public ResponseEntity<DoctorDTO> allocatePatient(@PathVariable String patientId, @PathVariable String doctorId)
    {
        DoctorDTO tmp = hospitalService.allocatePatient(patientId, doctorId);
        return new ResponseEntity<>(tmp, CREATED);
    }

}
