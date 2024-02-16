package med.voll.api.domain.appointment;

import med.voll.api.domain.appointment.entity.Appointment;
import med.voll.api.domain.doctor.DoctorRepository;
import med.voll.api.domain.doctor.entity.Doctor;
import med.voll.api.domain.exceptions.DoctorNotFoundException;
import med.voll.api.domain.exceptions.PatientNotFoundException;
import med.voll.api.domain.patients.PatientsRepository;
import med.voll.api.domain.patients.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentSchedule {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientsRepository patientsRepository;


    public void schedule(AppointmentData data) {
        if (!patientsRepository.existsById(data.patient_id())) {
            throw new PatientNotFoundException("Patient not found!");
        }
        if (data.doctor_id() != null && !doctorRepository.existsById(data.doctor_id())) {
            throw new DoctorNotFoundException("Doctor not found!");
        }
        // doctorRepository.findById(data.doctor_id()).orElseThrow(RuntimeException::new);
        Doctor doctor =  chooseDoctor(data);
        Patient patient = patientsRepository.findById(data.patient_id()).orElseThrow(RuntimeException::new);
        Appointment appointment = new Appointment(null, doctor, patient, data.appointment_date());
        appointmentRepository.save(appointment);
    }


    private Doctor chooseDoctor(AppointmentData data) {
        return new Doctor();
    }

}
