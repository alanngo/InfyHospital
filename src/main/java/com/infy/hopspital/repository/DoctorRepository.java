package com.infy.hopspital.repository;

import com.infy.hopspital.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository  extends MongoRepository<Doctor, String>
{
}
