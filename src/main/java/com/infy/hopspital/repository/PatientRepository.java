package com.infy.hopspital.repository;

import com.infy.hopspital.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
}
