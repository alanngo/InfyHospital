package com.infy.hopspital.repository;

import com.infy.hopspital.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DoctorRepository  extends MongoRepository<Doctor, String>
{

}
