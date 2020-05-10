package com.capgemini.app.repositery;
import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.app.entity.Appointment;
@Repository
public interface AppointmentRepositery extends JpaRepository<Appointment,BigInteger>{

}
