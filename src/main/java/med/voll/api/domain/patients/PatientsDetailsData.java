package med.voll.api.domain.patients;

import med.voll.api.domain.address.entity.Address;
import med.voll.api.domain.patients.entity.Patient;

import java.util.Date;

public record PatientsDetailsData(
        Long id,
        String name,
        String email,
        String telephone,
        String cpf,
        Sex sex,
        Date birthdate,
        Address address
) {
    public PatientsDetailsData(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getTelephone(), patient.getCpf(), patient.getSex(), patient.getBirthdate(),patient.getAddress());
    }
}
