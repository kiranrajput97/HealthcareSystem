package com.capgemini.app.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.app.dao.AppointmentDao;
import com.capgemini.app.dto.AppointmentDto;
import com.capgemini.app.entity.Appointment;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.entity.User;
import com.capgemini.app.exception.InvalidException;
import com.capgemini.app.exception.NullException;
import com.capgemini.app.exception.WrongValueException;

/************************************************************************************
 *          @author          Sachin kumar
 *          
 *          Description      It is a Appointment service class that provides the functionality 
 *          				 to find All Appointment,make Appointment,Approve Appointment
                             
 *          Created Date    27-APR-2020
 ************************************************************************************/
@Transactional
@Service
public class AppointmentServiceImpl implements AppointmentService{
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Override
	public boolean addAppointment(AppointmentDto appointment) {
		// TODO Auto-generated method stub
		if(appointmentDao.makeAppointment(appointment)) {
			return true;
		}
		else {
			throw new NullException("Check again your input data!!!");
		}
	}


	@Override
	public Appointment viewAppointment(long appointmentId) {
		if(appointmentDao.viewAppointment(appointmentId)!=null) {
			return appointmentDao.viewAppointment(appointmentId);
		}
		else {
			throw new WrongValueException("Wrong Appointment ID!!!");
		}
	}

	@Override
	public List<Appointment> viewAppointmentList() {
		// TODO Auto-generated method stub
		if( appointmentDao.getAppointmentList()!=null) {
			return appointmentDao.getAppointmentList();
		}
		else {
			throw new NullException("Appointment List is empty!!!");
		}
	
	}

	@Override
	public DiagnosticCenter view(long centerId) {
		if(appointmentDao.view(centerId)!=null) {
			return appointmentDao.view(centerId);
		}
		else {
			throw new NullException("Wrong CenterID!!!");
		}
		
	}

	@Override
	public Test viewTest(long id) {
		// TODO Auto-generated method stub
		if(appointmentDao.viewTest(id)!=null) {
			return appointmentDao.viewTest(id);
		}
		else {
			throw new NullException("Wrong TestID!!!");
		}
	}

	@Override
	public boolean approveAppointment(long id) {
		// TODO Auto-generated method stub
		if(appointmentDao.approveAppointment(id)) {
			return appointmentDao.approveAppointment(id);
		}
		else {
		throw new InvalidException("Appointment is already approved!!!");
		}
	}


	@Override
	public User viewUser(long id) {
		// TODO Auto-generated method stub
		if(appointmentDao.viewUser(id)!=null) {
			return appointmentDao.viewUser(id);
		}
		else {
			throw new NullException("Wrong UserID!!!");
		}
	}


	@Override
	public List<DiagnosticCenter> viewDiagnosticCenterList() {
		// TODO Auto-generated method stub
		return appointmentDao.viewDiagnosticCenterList();
	}

}
