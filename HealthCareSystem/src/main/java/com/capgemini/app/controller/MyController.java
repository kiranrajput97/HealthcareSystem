package com.capgemini.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.dto.AppointmentDto;
import com.capgemini.app.entity.Appointment;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.entity.User;
import com.capgemini.app.exception.InvalidException;
import com.capgemini.app.exception.NullException;
import com.capgemini.app.exception.WrongValueException;
import com.capgemini.app.service.AppointmentService;

/************************************************************************************
 *          @author          Kiran Rajput
 *          
 *          Description      It is a Main controller class that provides the functionality 
 *          				 to interact customer to our product and return to the requests to frontend
                             
  *         Created Date    27-APR-2020
 ************************************************************************************/
@SpringBootApplication
@RestController
@CrossOrigin
public class MyController {
	@Autowired
	private AppointmentService appointmentService;
	
	/************************************************************************************
	 * Method: getAllAppointment
     *Description: To view list of all appointments
	 * @returns ResponseEntity      - 200 OK, if At least one appoinment data exists
	 * @throws NullException - It is raised due to blank appointment list
	 ************************************************************************************/
	@GetMapping("/getAllAppointment")
    public ResponseEntity<List<Appointment>> getAllAppointmentDetails() {
		try {
			List<Appointment> listAppointment = appointmentService.viewAppointmentList();
			return new ResponseEntity<List<Appointment>>(listAppointment,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
	}
	
	
	/************************************************************************************
	 * Method: approveAppointment
     *Description: To approve appointment by the admin
	 * @returns true      - 200 OK, if appointment is approved
	 * @throws InvalidException - It is raised due to approve a already approved appointment
	 ************************************************************************************/
	@PutMapping("/approveAppointment/{AppointmentId}")
	@CrossOrigin(origins="http://localhost:4200")
    public String approveAppointment(@PathVariable("AppointmentId") long id) {
		try {
			if(appointmentService.approveAppointment(id)==true) {
				return "Appointment is approved!!!";
			}
		}
		catch(Exception e) {
			throw new InvalidException(e.getMessage());
		}
		return "Appointment is approved!!!";
	}

	/************************************************************************************
	 * Method: addApointment
     *Description: To add a appointment for any test by user.
	 * @returns true      - 200 OK, if appointment is booked.
	 * @throws NullException - It is raised due to leave a blank space 
	 ************************************************************************************/

	@PostMapping("/addApointment")
	public String addAppointment(@RequestBody AppointmentDto appointment ) {
		try {
			appointmentService.addAppointment(appointment);
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
		return "Appointment Added SUCESSFULLY!!!";
	}

	/************************************************************************************
	 * Method: getAppointmentById
     *Description: To view any appointment by the user
	 * @returns true      - 200 OK, if appointment id correct
	 * @throws WrongValueException - It is raised due to wrong apointment Id
	 ************************************************************************************/
	@GetMapping("/getAppointment/{AppointmentId}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("AppointmentId") long id) {
		Appointment appointment;
		try {
			appointment = appointmentService.viewAppointment(id);
		}
		catch(Exception e) {
			throw new WrongValueException(e.getMessage());
		}
		return new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
	}
	
	@GetMapping("/getCenter/{centerId}")
    public ResponseEntity<DiagnosticCenter> getCenterById(@PathVariable("centerId") long id) {
		try {
			DiagnosticCenter center = appointmentService.view(id);
			return new ResponseEntity<DiagnosticCenter>(center,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
	}
	
	@GetMapping("/getAllCenters")
    public ResponseEntity<List<DiagnosticCenter>> getAllCenters() {
		try {
			List<DiagnosticCenter> centerList = appointmentService.viewDiagnosticCenterList();
			return new ResponseEntity<List<DiagnosticCenter>>(centerList,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
	}
	
	@GetMapping("/getTest/{testId}")
    public ResponseEntity<Test> getTestById(@PathVariable("testId") long id) {
		
		Test test= appointmentService.viewTest(id);
		try {
			if(test!=null)
				return new ResponseEntity<Test>(test,HttpStatus.OK);
			}
			catch(Exception e) {
				throw new NullException(e.getMessage());
			}
		return new ResponseEntity<Test>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") long id) {
		User user= appointmentService.viewUser(id);
		try {
			if(user!=null)
				return new ResponseEntity<User>(user,HttpStatus.OK);
			}
			catch(Exception e) {
				throw new NullException(e.getMessage());
			}
		return new ResponseEntity<User>(user,HttpStatus.OK);

	}
}
