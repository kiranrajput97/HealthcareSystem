package com.capgemini.app.dao;

import java.util.List;

import com.capgemini.app.dto.AppointmentDto;
import com.capgemini.app.entity.Appointment;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.entity.User;
import javax.persistence.EntityManager;

public interface AppointmentDao {
	boolean makeAppointment(AppointmentDto appointment);
	Appointment viewAppointment(long appointmnetId);
	List<Appointment> getAppointmentList();
	DiagnosticCenter view(long centerId);
	Test viewTest(long id);
	boolean approveAppointment(long id);
	User viewUser(long id);
	List<DiagnosticCenter> viewDiagnosticCenterList();
}
