package med.voll.api.model.doctor;

import med.voll.api.model.doctor.entity.Doctor;

public record ListDataDoctor(
        Long id,
        String name,
        String email,
        String crm,
        Specialty specialty
) {
    public ListDataDoctor(Doctor doctor) {
        this(doctor.getId() ,doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
