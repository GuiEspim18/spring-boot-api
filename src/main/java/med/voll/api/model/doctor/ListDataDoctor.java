package med.voll.api.model.doctor;

import med.voll.api.model.doctor.entity.Doctor;

public record ListDataDoctor(
        String name,
        String email,
        String crm,
        Specialty specialty
) {
    public ListDataDoctor(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
