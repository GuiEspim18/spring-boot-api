package med.voll.api.model.patients;

import med.voll.api.model.patients.entity.Patient;

public record ListPatientData(
        Long id,
        String name,
        String email,
        String cpf
) {
    public ListPatientData(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
