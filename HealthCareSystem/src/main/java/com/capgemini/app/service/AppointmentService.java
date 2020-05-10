package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.dto.AppointmentDto;
import com.capgemini.app.entity.Appointment;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.entity.User;

public interface AppointmentService {
	boolean addAppointment(AppointmentDto appointment);
	Appointment viewAppointment(long appointmentId);
	List<Appointment> viewAppointmentList();
	DiagnosticCenter view(long centerId);
	Test viewTest(long id);
	User viewUser(long id);
	boolean approveAppointment(long id);
	List<DiagnosticCenter> viewDiagnosticCenterList();
}
